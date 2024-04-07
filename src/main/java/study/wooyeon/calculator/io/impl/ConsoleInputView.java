package study.wooyeon.calculator.io.impl;

import study.wooyeon.calculator.io.InputViewAdapter;
import study.wooyeon.racing.message.Input;

import java.util.Scanner;

public class ConsoleInputView implements InputViewAdapter {

    private static final ConsoleInputView consoleInputView = new ConsoleInputView();
    private static final Scanner scanner = new Scanner(System.in);

    private ConsoleInputView() {}

    @Override
    public String inputPoint() {
        return scanner.nextLine();
    }

    public static ConsoleInputView getInstance() {
        return consoleInputView;
    }
}
