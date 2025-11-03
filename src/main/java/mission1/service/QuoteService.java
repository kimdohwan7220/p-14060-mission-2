package mission1.service;

import java.util.List;
import mission1.domain.Quote;
import mission1.domain.QuoteRepository;

public class QuoteService {
    private final QuoteRepository repository = new QuoteRepository();

    public Quote registerQuote(String content, String author) {
        return repository.save(content, author);
    }

    public List<Quote> findAllQuotes() {
        return repository.findAll();
    }
}
