package study.wooyeon.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class RectangleCalculatorTest {

    @Test
    @DisplayName("마름모나 사다리꼴은 허용하지 않으며 오직 직사각형만 허용한다.")
    void validation() {
        // given
        Point point1 = new Point(10, 10);
        Point point2 = new Point(22, 10);
        Point point3 = new Point(22, 18);
        Point point4 = new Point(10, 14);

        Points points = new Points(Arrays.asList(point1, point2, point3, point4));

        // when & then
        assertThatThrownBy(() -> new RectangleCalculator(points))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("직사각형이 아닙니다.");
    }

    @Test
    @DisplayName("사각형의 면적을 계산한다.")
    void Calculate_Rectangle_Area() {
        // given
        Point point1 = new Point(10, 10);
        Point point2 = new Point(22, 10);
        Point point3 = new Point(22, 18);
        Point point4 = new Point(10, 18);

        Points points = new Points(Arrays.asList(point1, point2, point3, point4));

        // when
        RectangleCalculator rectangleCalculator = new RectangleCalculator(points);
        Double areaExpect = rectangleCalculator.calculate();

        // then
        assertThat(areaExpect).isEqualTo(96, offset(0.00099));
    }

}