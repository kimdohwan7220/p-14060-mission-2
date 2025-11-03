package mission1.controller;

import mission1.domain.Quote;
import mission1.service.QuoteService;
import mission1.view.InputView;
import mission1.view.OutputView;

public class AppController {

    private final QuoteService service = new QuoteService();

    public void run() {
        OutputView.printHeader();

        while (true) {
            String command = InputView.commandInput();

            if (checkExit(command)) break;

            handleCommand(command);
        }
    }

    private boolean checkExit(String command) {
        if ("종료".equals(command)) {
            OutputView.printExit();
            return true;
        }
        return false;
    }

    private void handleCommand(String command) {
        if ("등록".equalsIgnoreCase(command)) {
            registerQuote();
        } else if ("목록".equalsIgnoreCase(command)) {
            listQuotes();
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
}