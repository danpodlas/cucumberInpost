package pl.dpodlaski.OOP;

public class Phone extends Products{
    private String name;
    private static double margin = 0.05;

    public Phone(String type, double price, String name) {
        super(type, price+price*margin);
        this.name = name;
    }

}
