package views.strategies;

import logic.Car;
import logic.CarHandler;
import views.CarEventListener;
import views.CarHandlingStrategy;

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
