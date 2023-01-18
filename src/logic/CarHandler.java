package logic;

import java.util.List;
import persistence.Controller;
import persistence.ControllerFactory;
import utils.CreatorType;

public class CarHandler {

    private static final Controller CONTROLLER;

    static {
        CONTROLLER = ControllerFactory.createController(CreatorType.CAR);
    }

    private CarHandler() {
    }

    public static List<Car> getCarList() {
        return CONTROLLER.getAllCars();
    }

    public static void saveCar(Car c) {
        CONTROLLER.insert(c);
    }

    public static void updateCar(Car c) {
        CONTROLLER.update(c);
    }

    public static void deleteCar(Car c) {
        CONTROLLER.delete(c);
    }
}
