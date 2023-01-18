package persistence;

import java.util.List;
import logic.Car;

public interface Controller {

    void insert(Car c);

    void update(Car c);

    void delete(Car c);

    List<Car> getAllCars();
}
