package study.wooyeon.calculator.domain;

import study.wooyeon.calculator.constant.ShapeType;
import study.wooyeon.racing.Validator;

import java.util.List;
import java.util.Objects;

public class TriangleCalculator implements Calculator, Validator<Points> {

    private final Points points;

    public TriangleCalculator(Points points) {
        validation(points);
        this.points = points;
    }
    @Override
    public Double calculate() {
        List<Point> pointList = this.points.getPoints();
        double distanceA = pointList.get(0).calculateDistance(pointList.get(1));
        double distanceB = pointList.get(1).calculateDistance(pointList.get(2));
        double distanceC = pointList.get(2).calculateDistance(pointList.get(0));

        double s = (distanceA + distanceB + distanceC) / 2;
        return Math.sqrt(s * (s - distanceA) * (s - distanceB) * (s - distanceC));
    }

    @Override
    public void validation(Points points) {

        if (!Objects.equals(points.getSize(), ShapeType.TRIANGLE.getPointCount())) {
            throw new IllegalStateException("좌표값이 3개가 아닙니다.");
        }

        Long distinctCount = points.getPoints().stream().distinct().count();
        if (!Objects.equals(distinctCount.intValue(), ShapeType.TRIANGLE.getPointCount())) {
            throw new IllegalStateException("삼각형이 아닙니다.");
        }

        Point point1 = points.getPoints().get(0);
        Point point2 = points.getPoints().get(1);
        Point point3 = points.getPoints().get(2);

        if ((point2.getY() - point1.getY()) * (point3.getX() - point2.getX())
                ==
            (point3.getY() - point2.getY()) * (point2.getX() - point1.getX())) {
            throw new IllegalStateException("삼각형이 아닙니다.");
        }
    }
}
