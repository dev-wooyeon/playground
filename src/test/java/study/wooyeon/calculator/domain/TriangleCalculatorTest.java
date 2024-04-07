package study.wooyeon.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class TriangleCalculatorTest {

    /**
     * 삼각형의 성립 조건
     * 1. 세 점이 모두 다른 위치에 있는가(중복되는 점이 없어야 한다.)
     * 2. 세 점이 일직선상에 위치하지 않는가
     */
    @Test
    @DisplayName("주어진 세 점은 삼각형의 성립조건을 만족해야 한다." +
            "1. 세 점이 모두 다른 위치에 있는가(중복되는 점이 없어야 한다.)")
    void validation1() {
        // given
        Point point1 = new Point(10, 10);
        Point point2 = new Point(10, 10);
        Point point3 = new Point(22, 18);

        Points points = new Points(Arrays.asList(point1, point2, point3));

        // when & then
        assertThatThrownBy(() -> new TriangleCalculator(points))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("삼각형이 아닙니다.");
    }

    @Test
    @DisplayName("주어진 세 점은 삼각형의 성립조건을 만족해야 한다." +
            "2. 세 점이 일직선상에 위치하지 않는가")
    void validation2() {
        // given
        Point point1 = new Point(10, 10);
        Point point2 = new Point(10, 12);
        Point point3 = new Point(10, 18);

        Points points = new Points(Arrays.asList(point1, point2, point3));

        // when & then
        assertThatThrownBy(() -> new TriangleCalculator(points))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("삼각형이 아닙니다.");
    }

    @Test
    @DisplayName("삼각형의 면적을 계산을 성공한다.")
    void calculate_triangle_success() {
        // given
        Point point1 = new Point(10, 10);
        Point point2 = new Point(14, 15);
        Point point3 = new Point(20, 8);

        Points points = new Points(Arrays.asList(point1, point2, point3));

        // when
        TriangleCalculator triangleCalculator = new TriangleCalculator(points);
        Double areaExpect = triangleCalculator.calculate();

        // then
        assertThat(areaExpect).isEqualTo(29, offset(0.00099));
    }
}