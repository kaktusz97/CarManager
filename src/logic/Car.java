package logic;

public class Car implements Comparable<Car> {

    private long id;
    private String lincencePlate;
    private String brand;
    private String model;
    private int engineSize;

    public Car() {
    }

    public Car(long id, String lincencePlate, String brand, String model,
            int engineSize) {
        this.id = id;
        this.lincencePlate = lincencePlate;
        this.brand = brand;
        this.model = model;
        this.engineSize = engineSize;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLincencePlate() {
        return lincencePlate;
    }

    public void setLincencePlate(String lincencePlate) {
        this.lincencePlate = lincencePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
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

}
