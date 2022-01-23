package kata.dev;

import kata.dev.entities.Product;

public  class KataSupermarketPricing {


    public  void  theProductQuantityInStockIsNullThrowException(Product product) {
        if (product.getAvailableQuantity()==0)
             throw  new RuntimeException("Non Authorized Product Quantity in Stock");

    }
}
