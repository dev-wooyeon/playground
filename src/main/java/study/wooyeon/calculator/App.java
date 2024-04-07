package study.wooyeon.calculator;

import study.wooyeon.calculator.constant.ShapeType;
import study.wooyeon.calculator.domain.*;
import study.wooyeon.calculator.io.InputViewAdapter;
import study.wooyeon.calculator.io.OutputViewAdapter;
import study.wooyeon.calculator.io.impl.ConsoleInputView;
import study.wooyeon.calculator.io.impl.ConsoleOutputView;
import study.wooyeon.calculator.util.Parser;

public class App {
    public static void main(String[] args) {

        InputViewAdapter input = ConsoleInputView.getInstance();
        OutputViewAdapter output = ConsoleOutputView.getInstance();
        output.printInputMessage();
        String point = input.inputPoint();

        Parser parser = Parser.getInstance();
        Points points = parser.getPoint(point);

        if (points.getSize() == ShapeType.LINE.getPointCount()) {
            Calculator lineCalculator = new LineCalculator(points);
            output.printResult(ShapeType.LINE, lineCalculator.calculate());
        }
        if (points.getSize() == ShapeType.TRIANGLE.getPointCount()) {
            Calculator triangleCalculator = new TriangleCalculator(points);
            output.printResult(ShapeType.TRIANGLE, triangleCalculator.calculate());
        }
        if (points.getSize() == ShapeType.RECTANGLE.getPointCount()) {
            Calculator rectangleCalculator = new RectangleCalculator(points);
            output.printResult(ShapeType.RECTANGLE, rectangleCalculator.calculate());
        }
    }
}
