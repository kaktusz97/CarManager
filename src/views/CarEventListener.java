package views;

import logic.Car;

/**
 *
 * @author Marci
 */
public interface CarEventListener {

    void carCreated(Car c);

    void carUpdated();

    void carDeleted(Car c);
}
