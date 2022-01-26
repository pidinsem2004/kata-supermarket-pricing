package kata.dev.entities;

import kata.dev.dao.DataAccess;

import java.util.List;

public class OfferRule {
    private String productName;
    private int quantity;
    private int offerPrice;



    public OfferRule() {
    }

    public OfferRule(String productName, int quantity, int offerPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.offerPrice = offerPrice;

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(int offerPrice) {
        this.offerPrice = offerPrice;
    }


    @Override
    public String toString() {
        return "OfferRule{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", offerPrice=" + offerPrice +
                '}';
    }




}

//

