package view;

import logic.Car;

/**
 *
 * @author Marci
 */
public interface CarHandlingStrategy {

    void save(Car c);

    void notify(Car c, CarEventListener l);
}
