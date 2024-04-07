package study.wooyeon.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LineCalculatorTest {

    @Test
    @DisplayName("두 점 사이의 거리의 계산을 성공한다.")
    void calculator_line_success() {
        Point point1 = new Point(12, 3);
        Point point2 = new Point(3, 0);

        Points points = new Points(Arrays.asList(point1, point2));

        LineCalculator lineCalculator = new LineCalculator(points);
        Double lengthExpect = lineCalculator.calculate();

        assertThat(lengthExpect).isEqualTo(Math.sqrt(90), offset(0.00099));
    }


}