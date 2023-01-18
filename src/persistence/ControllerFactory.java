package persistence;

import utils.CreatorType;

public class ControllerFactory {

    public static Controller createController(CreatorType type) {
        switch (type) {
            default:
                return new CarController();
        }
    }
}
