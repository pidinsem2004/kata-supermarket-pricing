package kata.dev;

import kata.dev.entities.OfferRule;
import kata.dev.entities.Order;
import kata.dev.entities.Product;
import kata.dev.service.OrderService;

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

    public void productQuantityInOrderShouldBeGreaterThanZero(Order order) {
        if(order.getOrderQuantity()==0)
            throw new RuntimeException("Non Authorized null quantity");
    }

    public void pricingRuleWithoutProductThrowException(OfferRule or) {
        if (or.getProductName().equalsIgnoreCase("") || or.getProductName()==null)
            throw  new RuntimeException("Invalid Offer Rule without product name ");

    }

    public void addingPricingRuleWithoutQuantityThrowException(OfferRule or) {
        if (or.getQuantity()==0)
            throw  new RuntimeException("Invalid Offer Quantity");
    }
    public void addingPricingRuleWithoutSpecialPriceThrowException(OfferRule or) {
        if(or.getOfferPrice()==0)
            throw  new RuntimeException("Invalid offer price");
    }

    public int  AddingPricingRule(List<OfferRule> offerRuleList) {
        return  offerRuleList.size();
    }

}
