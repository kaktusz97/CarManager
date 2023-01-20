package persistence;

import java.util.ArrayList;
import java.util.List;
import logic.Car;
import utils.StringFormatter;

class CarController implements Controller {

    public static final String FILE_NAME = "car.txt";

    @Override
    public void insert(Car c) {
        List<List<String>> data = FileHandler.readIn(FILE_NAME);
        List<String> carRow = createListFromCar(c);
        data.add(carRow);
        FileHandler.writeOut(data, FILE_NAME);
    }

    @Override
    public void update(Car c) {
        List<Car> cars = getAllCars();
        int index = cars.indexOf(c);
        if (index > -1) {
            cars.set(index, c);
            List<List<String>> writable = stringListFromCarList(cars);
            FileHandler.writeOut(writable, FILE_NAME);
        }
    }

    private List<String> createListFromCar(Car c) {
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(c.getId()));
        result.add(c.getLicencePlate().
                toUpperCase());
        result.add(StringFormatter.firstCharUpperRestLower(c.getBrand()));
        result.add(StringFormatter.firstCharUpperRestLower(c.getModel()));
        result.add(String.valueOf(c.getEngineSize()));
        return result;
    }

    @Override
    public List<Car> getAllCars() {
        List<List<String>> rows = FileHandler.readIn(FILE_NAME);
        List<Car> result = new ArrayList<>();
        for (List<String> row : rows) {
            Car temp = createCarFromStringList(row);
            result.add(temp);
        }
        return result;
    }

    private Car createCarFromStringList(List<String> row) {
        long id = Long.parseLong(row.get(0));
        String licencePlate = row.get(1).
                toUpperCase();
        String brand = StringFormatter.firstCharUpperRestLower(row.get(2));
        String type = StringFormatter.firstCharUpperRestLower(row.get(3));
        int engine = Integer.parseInt(row.get(4));
        return new Car(id, licencePlate, brand, type, engine);
    }

    private List<List<String>> stringListFromCarList(List<Car> cars) {
        List<List<String>> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(createListFromCar(car));
        }
        return result;
    }

    @Override
    public void delete(Car c) {
        List<Car> cars = getAllCars();
        int index = cars.indexOf(c);
        if (index > -1) {
            cars.remove(index);
            List<List<String>> writable = stringListFromCarList(cars);
            FileHandler.writeOut(writable, FILE_NAME);
        }
    }
}
