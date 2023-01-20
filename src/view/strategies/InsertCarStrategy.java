package view.strategies;

import logic.Car;
import logic.CarHandler;
import view.CarEventListener;
import view.CarHandlingStrategy;

public class InsertCarStrategy implements CarHandlingStrategy {
    
    @Override
    public void save(Car c) {
        CarHandler.saveCar(c);
    }
    
    @Override
    public void notify(Car c, CarEventListener l) {
        l.carCreated(c);
    }
    
}
