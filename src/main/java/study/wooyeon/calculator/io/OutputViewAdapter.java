package study.wooyeon.calculator.io;

import study.wooyeon.calculator.constant.ShapeType;

public interface OutputViewAdapter {
    void printInputMessage();
    void printResult(ShapeType shapeType, double result);
}
