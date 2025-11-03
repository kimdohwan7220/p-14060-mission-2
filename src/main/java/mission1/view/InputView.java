package mission1.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String commandInput() {
        System.out.print("명령) ");
        return sc.nextLine().trim();
    }

    public static String quoteInput() {
        System.out.print("명언 : ");
        return sc.nextLine().trim();
    }

    public static String authorInput() {
        System.out.print("작가 : ");
        return sc.nextLine().trim();
    }
}
