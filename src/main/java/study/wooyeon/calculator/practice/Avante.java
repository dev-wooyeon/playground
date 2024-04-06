package study.wooyeon.calculator.practice;

public class Avante extends Car<Avante>{

    public Avante(double tripDistance) {
        super(15, tripDistance);
    }
    @Override
    String getName() {
        return this.getClass().getSimpleName();
    }
}
