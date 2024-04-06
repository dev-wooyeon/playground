package study.wooyeon.calculator.practice;

public class K5 extends Car<K5>{

    public K5(double tripDistance) {
        super(13, tripDistance);
    }

    @Override
    String getName() {
        return this.getClass().getSimpleName();
    }
}
