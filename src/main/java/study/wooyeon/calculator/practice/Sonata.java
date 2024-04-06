package study.wooyeon.calculator.practice;

public class Sonata extends Car<Sonata> {

    public Sonata(double tripDistance) {
        super(10, tripDistance);
    }

    @Override
    String getName() {
        return this.getClass().getSimpleName();
    }
}

