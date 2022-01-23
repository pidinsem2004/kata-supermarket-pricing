package kata.dev.dao;

import kata.dev.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class DataAcces {
    private List<Product> productList = new ArrayList<Product>();

    public List<Product>  getProductList(){
        initProductList();
        return productList;
    }
    private void initProductList (){
      productList.add(new Product("A",10,50, false));

    }
}
