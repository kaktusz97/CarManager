package logic;

import utils.ParamValidator;

public class Car implements Comparable<Car> {

    private long id;
    private String licencePlate;
    private String brand;
    private String model;
    private int engineSize;

    public Car() {
    }

    public Car(long id, String licencePlate, String brand, String model,
            int engineSize) {
        this.id = id;
        this.licencePlate = licencePlate;
        this.brand = brand;
        this.model = model;
        this.engineSize = engineSize;
    }

    public long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        if (ParamValidator.checkLincencePlate(licencePlate)) {
            this.licencePlate = licencePlate;
        } else {
            throw new IllegalArgumentException("wrong licencePlate");
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (ParamValidator.isBetween(brand.length(), 3, 15)
                && ParamValidator.isLettersOnly(brand)) {
            this.brand = brand;
        } else {
            throw new IllegalArgumentException("wrong brand");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (ParamValidator.isBetween(model.length(), 1, 15)) {
            this.model = model;
        } else {
            throw new IllegalArgumentException("wrong model");
        }
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        if (ParamValidator.isBetween(engineSize, 700, 8000)) {
            this.engineSize = engineSize;
        } else {
            throw new IllegalArgumentException("wrong engineSize");
        }
    }

    @Override
    public int compareTo(Car o) {
        return (int) ((int) id - o.id);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Car
                && id == ((Car) obj).id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

}
