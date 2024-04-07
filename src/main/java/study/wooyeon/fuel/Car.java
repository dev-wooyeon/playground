package study.wooyeon.fuel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Car<T extends Car<T>>{
    // 리터당 이동 거리. 즉, 연비
    private final double distancePerLiter;
    // 여행하려는 거리
    private final double tripDistance;

    abstract String getName();

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
