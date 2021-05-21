package pl.dpodlaski.OOP;


public class Laptops extends Products{

    private String name;
    private String model;

    public Laptops(String type, double price, String name, String model) {
        super(type, price);
        this.name = name;
        this.model = model;
    }

    public Laptops(String type, double price, String name) {
        super(type, price);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
