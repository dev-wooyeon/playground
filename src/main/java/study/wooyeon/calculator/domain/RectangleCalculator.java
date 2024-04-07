package study.wooyeon.calculator.domain;

import study.wooyeon.calculator.constant.ShapeType;
import study.wooyeon.racing.Validator;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class RectangleCalculator implements Calculator, Validator<Points> {

    private final Points points;

    public RectangleCalculator(Points points) {
        validation(points);
        this.points = points;
    }
    @Override
    public Double calculate() {

        List<Point> pointList = this.points.getPoints();

        Integer minX = pointList.stream().mapToInt(Point::getX).min().orElseThrow(NoSuchElementException::new);
        Integer maxX = pointList.stream().mapToInt(Point::getX).max().orElseThrow(NoSuchElementException::new);
        Integer minY = pointList.stream().mapToInt(Point::getY).min().orElseThrow(NoSuchElementException::new);
        Integer maxY = pointList.stream().mapToInt(Point::getY).max().orElseThrow(NoSuchElementException::new);

        Integer width = maxX - minX;
        Integer height = maxY - minY;

        return (double)(width * height);
    }

    @Override
    public void validation(Points points) {

        if (!Objects.equals(points.getSize(), ShapeType.RECTANGLE.getPointCount())) {
            throw new IllegalStateException("좌표값이 4개가 아닙니다.");
        }

        List<Point> pointList = points.getPoints();
        Long countX = pointList.stream().map(Point::getX).distinct().count();
        Long countY = pointList.stream().map(Point::getY).distinct().count();

        if (!Objects.equals(2L, countX) || !Objects.equals(2L, countY))  {
            throw new IllegalStateException("직사각형이 아닙니다.");
        }
    }
}
