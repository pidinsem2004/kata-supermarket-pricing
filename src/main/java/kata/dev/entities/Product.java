package kata.dev.entities;



public class Product {
    private String name ;
    private int price;
    private int availableQuantity;
    private boolean isOffered;


    public Product() {
    }

    public Product(String name, int price, int availableQuantity, boolean isOffered) {
        this.name = name;
        this.price = price;
        this.isOffered = isOffered;
        this.availableQuantity = availableQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isOffered() {
        return isOffered;
    }

    public void setOffered(boolean offered) {
        isOffered = offered;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", availableQuantity=" + availableQuantity +
                ", isOffered=" + isOffered +
                '}';
    }
}
