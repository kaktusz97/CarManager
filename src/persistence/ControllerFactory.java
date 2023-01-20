package persistence;

import utils.ControllerType;

public class ControllerFactory {

    public static Controller createController(ControllerType type) {
        switch (type) {
            default:
                return new CarController();
        }
    }
}
