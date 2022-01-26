package kata.dev.dao;

import kata.dev.entities.OfferRule;
import kata.dev.entities.Order;
import kata.dev.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    private  List<Product> productList = new ArrayList<Product>();
    private  List<OfferRule> offerRules = new ArrayList<OfferRule>();
    private  List<Order> orderList = new ArrayList<Order>();

    public DataAccess() {
        initProductList();
    }

    public List<Product> getProductList() {

        return productList;
    }

    public List<OfferRule> getOfferRules() {

        return offerRules;
    }

    public List<Order> getOrderList() {

        return orderList;
    }

    private  void initProductList() {
        Product productA = new Product("A", 65, 0, false);
        Product productB = new Product("", 65, 0, false);
        Product productC = new Product("A", 65, 100, true);

        productList.add(productA);
        productList.add(productB);
        productList.add(productC);

        //init OfferRules
        offerRules.add(new OfferRule(productA.getName(), 3, 1));
        offerRules.add(new OfferRule(productB.getName(), 3, 1));
        offerRules.add(new OfferRule(productC.getName(), 3, 1));

        //init order
        orderList.add(new Order(productA, 10));
        orderList.add(new Order(productB, 5));
        orderList.add(new Order(productA, 10));
        orderList.add(new Order(productC, 4));



    }


}
