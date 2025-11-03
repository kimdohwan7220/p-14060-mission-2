package mission1.domain;

import java.util.ArrayList;
import java.util.List;

public class QuoteRepository {
    private final List<Quote> quotes = new ArrayList<>();
    private int nextId = 1; // 자동 증가 ID

    public Quote save(String content, String author) {
        Quote quote = new Quote(getNextId(), content, author);
        quotes.add(quote);
        return quote;
    }

    private int getNextId() {
        return nextId++;
    }

    public List<Quote> findAll() {
        return new ArrayList<>(quotes);
    }

    public boolean deleteById(int id) {
        return quotes.removeIf(q -> q.getId() == id);
    }
}