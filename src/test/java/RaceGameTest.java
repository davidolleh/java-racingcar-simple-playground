import domain.Car;
import domain.CarName;
import domain.Cars;
import domain.RaceGame;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class RaceGameTest {

    @Test
    void 가장_멀리간_자동차들을_반환한다() {
        Cars cars = new Cars(List.of(new Car(CarName.stringToName("지바겐")), new Car(CarName.stringToName("포르쉐")), new Car(CarName.stringToName("쉐보레"))));

        RaceGame raceGame = new RaceGame(cars, 5, new MockRule.MoreThan4NumberGenerator());

        assertThat(raceGame.getWinners()).isEqualTo(cars.getCars());
    }
    @Test
    public void 랜덤_숫자가_3이하이면_자동차_정지() {
        Cars cars = new Cars(List.of(new Car(CarName.stringToName("지바겐")), new Car(CarName.stringToName("포르쉐")), new Car(CarName.stringToName("쉐보레"))));


        RaceGame raceGame = new RaceGame(cars, 5, new MockRule.LessThan4NumberGenrator());

        raceGame.start();

        for(Car car: cars.getCars()) {
            assertThat(car.getLocation()).isEqualTo(0);
        }
    }

    @Test
    public void 랜덤_숫자가_4이상이면_자동차_전진() {
        Cars cars = new Cars(List.of(new Car(CarName.stringToName("지바겐")), new Car(CarName.stringToName("포르쉐")), new Car(CarName.stringToName("쉐보레"))));


        RaceGame raceGame = new RaceGame(cars, 5, new MockRule.MoreThan4NumberGenerator());

        raceGame.start();

        for(Car car: cars.getCars()) {
            assertThat(car.getLocation()).isEqualTo(5);
        }
    }
}
