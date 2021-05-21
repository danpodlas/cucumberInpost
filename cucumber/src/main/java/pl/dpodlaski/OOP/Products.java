package pl.dpodlaski.OOP;

public abstract class Products implements TaxForProducts {

    private String type;
    private double price;

    public Products(String type, double price) {
        this.type = type;
        this.price = addTaxForProduct(type, price);
    }

    @Override
    public double addTaxForProduct(String type, double price) {
        if(type.equals("premium")){
            return price + (price*0.2);
        }else {
            return price + (price*0.1);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
