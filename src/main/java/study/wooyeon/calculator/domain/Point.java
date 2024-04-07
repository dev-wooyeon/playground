package study.wooyeon.calculator.domain;

import lombok.Getter;
import lombok.Setter;
import study.wooyeon.calculator.util.Validator;

@Getter
@Setter
public class Point implements Validator<Point> {

    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        validation(this);
    }

    public Double calculateDistance(Point point2) {
        return Math.sqrt(
                Math.pow(point2.getX() - this.getX(), 2)
                        +
                Math.pow(point2.getY() - this.getY(), 2)
        );
    }

    @Override
    public void validation(Point point) {
        Integer x = point.getX();
        Integer y = point.getY();
        if (x < 0 || x > 24 || y < 0 || y > 24) {
            throw new IllegalArgumentException("좌표가 범위를 벗어났습니다.");
        }
    }
}
