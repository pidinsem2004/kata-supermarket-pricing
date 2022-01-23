package kata.dev.entities;

public class Order {

    private Product orderProduct;
    private int orderQuantity;

    public Order() {
    }

    public Order(Product orderProduct, int orderQuantity) {
        this.orderProduct = orderProduct;
        this.orderQuantity = orderQuantity;
    }

    public Product getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Product orderProduct) {
        this.orderProduct = orderProduct;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderProduct=" + orderProduct +
                ", orderQuantity=" + orderQuantity +
                '}';
    }
}
