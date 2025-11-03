package mission1.utils;

import mission1.domain.Quote;
import mission1.service.QuoteService;
import mission1.view.InputView;
import mission1.view.OutputView;

public class QuoteHandler {

    private final QuoteService service;

    public QuoteHandler(QuoteService service) {
        this.service = service;
    }

    public void handleCommand(String command) {
        if ("등록".equalsIgnoreCase(command)) {
            registerQuote();
        } else if ("목록".equalsIgnoreCase(command)) {
            listQuotes();
        } else if (command.startsWith("삭제?id=")) {
            deleteQuote(command);
        }
    }

    private void registerQuote() {
        String content = InputView.quoteInput();
        String author = InputView.authorInput();

        Quote quote = service.registerQuote(content, author);

        OutputView.printQuoteRegistered(quote);
    }

    private void listQuotes() {
        var quotes = service.findAllQuotes();
        OutputView.printQuoteList(quotes);
    }

    private void deleteQuote(String command) {
        int id = Integer.parseInt(command.substring("삭제?id=".length()));
        try {
            service.deleteQuote(id);
            OutputView.printQuoteDeleted(id);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
