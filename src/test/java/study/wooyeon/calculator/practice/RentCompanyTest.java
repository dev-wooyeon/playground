package study.wooyeon.calculator.practice;

import org.junit.jupiter.api.Test;
import study.wooyeon.fuel.Avante;
import study.wooyeon.fuel.K5;
import study.wooyeon.fuel.RentCompany;
import study.wooyeon.fuel.Sonata;

import static org.assertj.core.api.Assertions.assertThat;

public class RentCompanyTest {

    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    public void report() {
        RentCompany company = RentCompany.create(); // factory method를 사용해 생성
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        assertThat(report).isEqualTo(
                "Sonata : 15리터" + NEWLINE +
                "K5 : 20리터" + NEWLINE +
                "Sonata : 12리터" + NEWLINE +
                "Avante : 20리터" + NEWLINE +
                "K5 : 30리터" + NEWLINE
        );
    }
}