package mission1.domain;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class QuoteRepository {

    private static final Path BASE_DIR = Paths.get("db", "wiseSaying");
    private static final Path LAST_ID_FILE = BASE_DIR.resolve("lastId.txt");

    public QuoteRepository() {
        initializeStorage();
    }

    private void initializeStorage() {
        try {
            Files.createDirectories(BASE_DIR);
            if(!Files.exists(LAST_ID_FILE)) {
                Files.writeString(LAST_ID_FILE, "0", StandardCharsets.UTF_8);
            }
        } catch (IOException ignored) {};
    }

    public Quote save(String content, String author) {
        int newId = nextId();
        Quote quote = new Quote(newId, content, author);
        quotes.add(quote);
        return quote;
    }

    private int nextId() {
        return readLastId() + 1;
    }


    private int readLastId() {
        try {
            if (!Files.exists(LAST_ID_FILE)) return 0;
            String value = Files.readString(LAST_ID_FILE, StandardCharsets.UTF_8).trim();
            if (value.isEmpty()) return 0;
            return Integer.parseInt(value);
        } catch (Exception e) {
            return 0;
        }
    }

    private final List<Quote> quotes = new ArrayList<>();
    private int nextId = 1; // 자동 증가 ID


    private int getNextId() {
        return nextId++;
    }

    public List<Quote> findAll() {
        return new ArrayList<>(quotes);
    }

    public boolean deleteById(int id) {
        return quotes.removeIf(q -> q.getId() == id);
    }

    public Quote findById(int id) {
        return quotes.stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(int id, String content, String author) {
        Quote q = findById(id);
        if (q != null) {
            quotes.set(quotes.indexOf(q), new Quote(id, content, author));
        }
    }
}