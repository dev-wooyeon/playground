package study.wooyeon.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Points {

    private final List<Point> points;

    public int getSize() {
        return this.points.size();
    }

}
