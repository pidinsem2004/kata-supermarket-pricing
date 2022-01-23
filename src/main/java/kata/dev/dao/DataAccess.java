package kata.dev.dao;

import kata.dev.entities.OfferRule;
import kata.dev.entities.Order;
import kata.dev.entities.Product;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    private static List<Product> productList = new ArrayList<Product>();
    private static List<OfferRule> offerRules = new ArrayList<OfferRule>();
    private static List<Order> orderList  = new ArrayList<Order>();

    public DataAccess (){
        initProductList();
    }

    public List<Product>  getProductList(){
          return productList;
    }
    public List<OfferRule> getOfferRules (){
        return  offerRules;
    }

    public List<Order> getOrderList (){
        return orderList;
    }

    private void initProductList (){
        Product productA = new Product("A",10,0, false);
        Product productB = new Product("",10,0, false);
        Product productC = new Product("A",100,100, true);

        productList.add(productA);productList.add(productB);productList.add(productC);

        //init OfferRules
        offerRules.add(new OfferRule(productA.getName(),3,1));
        offerRules.add(new OfferRule(productB.getName(),3,1));
        offerRules.add(new OfferRule(productC.getName(),3,1));

        //init order


    }
}
