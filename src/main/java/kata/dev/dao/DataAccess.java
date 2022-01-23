package kata.dev.dao;

import kata.dev.entities.OfferRule;
import kata.dev.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    private List<Product> productList = new ArrayList<Product>();
    private List<OfferRule> offerRules = new ArrayList<OfferRule>();

    public List<Product>  getProductList(){
        initProductList();
        return productList;
    }
    public List<OfferRule>  getOfferRulesList(){
        initOfferRuleList();
        return offerRules;
    }

    private void initProductList (){
      productList.add(new Product("A",10,0, false));

    }
    private void initOfferRuleList(){
        offerRules.add(new OfferRule("A",3,1));
    }
}
