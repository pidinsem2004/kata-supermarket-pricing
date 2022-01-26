package kata.dev.service;

import kata.dev.dao.DataAccess;
import kata.dev.entities.Product;

import java.util.List;

public class ProductService {

    private List<Product> products = new DataAccess().getProductList();


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p) {
        if (p == null || p.getName() == "" || p.getPrice() == 0)
            throw new RuntimeException("Invalid product");

        else
            products.add(p);
    }

}
