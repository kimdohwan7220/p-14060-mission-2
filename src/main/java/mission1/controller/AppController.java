package mission1.controller;

import mission1.view.InputView;
import mission1.view.OutputView;

public class AppController {

    public void run() {
        OutputView.printHeader();

        while (true) {
            String command = InputView.commandInput();

            if (command.equals("종료")) {
                OutputView.printExit();
                break;
            }
        }
    }
}