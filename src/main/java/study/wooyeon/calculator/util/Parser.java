package study.wooyeon.calculator.util;

import study.wooyeon.calculator.domain.Point;
import study.wooyeon.calculator.domain.Points;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final Parser parser = new Parser();

    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";
    private static final String COMMA = ",";
    private static final String HYPHEN = "-";

    public Points getPoint(String input) {
        String[] split = input.split(HYPHEN);
        List<Point> points = Arrays.stream(split).map(this::parsePoint).collect(Collectors.toList());
        return new Points(points);
    }

    private Point parsePoint(String pair) {
        pair = pair.replace(LEFT_BRACKET, "").replace(RIGHT_BRACKET, "");
        String[] coordinates = pair.split(COMMA);
        int x = Integer.parseInt(coordinates[0].trim());
        int y = Integer.parseInt(coordinates[1].trim());
        return new Point(x, y);
    }

    public static Parser getInstance() {
        return parser;
    }

}
