package study.wooyeon.calculator.domain;

import study.wooyeon.calculator.constant.ShapeType;
import study.wooyeon.racing.Validator;

import java.util.List;
import java.util.Objects;

public class LineCalculator implements Calculator, Validator<Points> {

    private final Points points;

    public LineCalculator(Points points) {
        validation(points);
        this.points = points;
    }

    @Override
    public Double calculate() {
        Point point1 = this.points.getPoints().get(0);
        Point point2 = this.points.getPoints().get(1);
        return point1.calculateDistance(point2);
    }

    @Override
    public void validation(Points points) {

        if (!Objects.equals(points.getSize(), ShapeType.LINE.getPointCount())) {
            throw new IllegalStateException("좌표값이 2개가 아닙니다.");
        }

        List<Point> pointList = points.getPoints();
        if (Objects.equals(pointList.get(0).getX(), pointList.get(1).getX()) && Objects.equals(pointList.get(0).getY(), pointList.get(1).getY())) {
            throw new IllegalStateException("선이 아닙니다.");
        }
    }
}
