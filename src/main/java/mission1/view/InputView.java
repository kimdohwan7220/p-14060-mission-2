package mission1.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String commandInput() {
        System.out.print("명령) ");
        return sc.nextLine().trim();
    }
}
