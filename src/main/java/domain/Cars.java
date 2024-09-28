package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<CarName> carNames) {
        return new Cars(
                carNames.stream().map(Car::new).collect(Collectors.toList())
        );

    }

    public List<Car> getCars() {
        return cars;
    }
}
