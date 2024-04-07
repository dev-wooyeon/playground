package study.wooyeon.calculator.io.impl;

import study.wooyeon.calculator.constant.ShapeType;
import study.wooyeon.calculator.io.OutputViewAdapter;

import java.text.MessageFormat;

public class ConsoleOutputView implements OutputViewAdapter {

    private static final ConsoleOutputView consoleOutputView = new ConsoleOutputView();

    private ConsoleOutputView() {}

    public void printInputMessage() {
        System.out.print("좌표를 입력하세요.");
    }

    public void printResult(ShapeType shapeType, double result) {
        switch (shapeType) {
            case LINE -> System.out.println(MessageFormat.format("두 점 사이 거리는 {0}", result));
            case TRIANGLE -> System.out.println(MessageFormat.format("삼각형의 넓이는 {0}", result));
            case RECTANGLE -> System.out.println(MessageFormat.format("사각형의 넓이는 {0}", result));
        }
    }

    public static ConsoleOutputView getInstance() {
        return consoleOutputView;
    }
}
