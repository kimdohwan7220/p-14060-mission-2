package mission1.view;

import mission1.domain.Quote;

public class OutputView {

    public static void printHeader() {
        System.out.println("== 명언 앱 ==");
    }

    public static void printExit() {
        System.out.println("프로그램을 종료합니다.");
    }

    public static void printQuoteRegistered(Quote quote) {
        System.out.println(quote.getId() + "번 명언이 등록되었습니다.");
    }
}
