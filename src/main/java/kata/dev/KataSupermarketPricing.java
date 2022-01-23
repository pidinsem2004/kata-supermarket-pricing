package kata.dev;

import kata.dev.entities.Order;
import kata.dev.entities.Product;

import java.util.List;

public  class KataSupermarketPricing {


    public  void  theProductQuantityInStockIsNullThrowException(Product product) {
        if (product.getAvailableQuantity()==0)
             throw  new RuntimeException("Non Authorized Product Quantity in Stock");

    }

    public void theProductNameIsNullOrEmpty(Product product) {
     if(product.getName()==null || product.getName()=="")
         throw  new RuntimeException("The Product Name Should not be null or empty");
    }
    public boolean twoProductInStockWithTheSameName(Product p1, Product p2){

        if(p1.getName().equalsIgnoreCase(p2.getName()))
            throw  new RuntimeException("The product name should be unique");
        return true;
    }

    public void  oderWithNoProduct(List<Order> orderList) {
        if (orderList.size()==0)
            throw new RuntimeException("An order should have at least one product");
    }


    public void unavailableProductInStockThrowException(Order order) {
        if(order.getOrderProduct().getAvailableQuantity()==0)
            throw new RuntimeException("Unavailable product in Stock");
    }
}
