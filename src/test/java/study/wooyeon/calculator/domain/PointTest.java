package study.wooyeon.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("좌표(x, y) 생성을 성공한다.")
    void create_point_success() {
        // given
        Integer x = 2;
        Integer y = 14;

        // when
        Point point = new Point(x, y);

        // then
        assertThat(point.getX()).isEqualTo(2);
        assertThat(point.getY()).isEqualTo(14);
    }

    @ParameterizedTest
    @DisplayName("좌표(x, y) 생성을 실패한다.")
    @CsvSource(value = {"-1,3", "-1,-1", "0,25", "25,4", "25,25"}, delimiter = ',')
    void create_point_fail(int x, int y) {
        // given
        assertThatThrownBy(() -> new Point(x, y))
        // & when & then
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("좌표가 범위를 벗어났습니다.");
    }

    @Test
    @DisplayName("두 좌표간의 거리 계산을 성공한다.")
    void calculate_distance_success() {
        // given
        Point point1 = new Point(2, 4);
        Point point2 = new Point(4, 0);

        // when
        Double result = point1.calculateDistance(point2);
        System.out.println(result);

        // then
        // Todo. offset 정밀도 지정할 수 있다는건데 자세히 뭔지 알아보기
        assertThat(result).isEqualTo(Math.sqrt(20), offset(0.00099));
    }

}