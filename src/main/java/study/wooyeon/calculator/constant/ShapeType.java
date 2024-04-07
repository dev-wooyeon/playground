package study.wooyeon.calculator.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShapeType {
    LINE(2),
    TRIANGLE(3),
    RECTANGLE(4);

    private final Integer pointCount;
}
