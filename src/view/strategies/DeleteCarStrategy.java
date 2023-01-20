package view.strategies;

import logic.Car;
import logic.CarHandler;
import view.CarEventListener;
import view.CarHandlingStrategy;

public class DeleteCarStrategy implements CarHandlingStrategy {

    @Override
    public void save(Car c) {
        CarHandler.deleteCar(c);
    }

    @Override
    public void notify(Car c, CarEventListener l) {
        l.carDeleted(c);
    }

}
