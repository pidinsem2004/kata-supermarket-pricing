package kata.dev.service;

import kata.dev.dao.DataAccess;
import kata.dev.entities.Product;

import java.util.List;

/**
 * Cette Classe offre le service de gestion des produits. A partir
 * d'ici,l'utilisateur à la possibilité d'ajouter des nouveau produit
 * dans la collection, de récupérer la liste des produits
 * getProducts() : renvois la liste des produits
 * setProducts() : définit la liste des produits
 * addProduct(Product product) : ajoute un produit à la collection
 *
 * @author Jean Pierre NSEM
 */

public class ProductService {

    /**
     * Initialisation de la liste des produits
     */
    private List<Product> products = new DataAccess().getProductList();


    /**
     * Renvoie la listes des produits
     *
     * @return products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * assigne la liste des produits passée en paramètre
     *
     * @param products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Ajoute un produit à la liste
     *
     * @param product : le produit
     * @throws RuntimeException lève une exception si le produit est invalide
     */
    public void addProduct(Product product) {
        if (product == null || product.getName() == "" || product.getPrice() == 0)
            throw new RuntimeException("Invalid product");

        else
            products.add(product);
    }
}