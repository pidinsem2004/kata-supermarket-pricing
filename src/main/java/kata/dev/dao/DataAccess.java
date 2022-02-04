package kata.dev.dao;

import kata.dev.entities.OfferRule;
import kata.dev.entities.Order;
import kata.dev.entities.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette Classe va permettre de mocker le système d'accès aux données,
 * ainsi on n'a pas besoin d'une base de données pendant les développements et
 * les tests.
 * elle dispose d'un trois collections qui permettent de définir les données
 * productList : définit la collection des produits
 * offerRules  : définit la collection des offres promotionnelles
 * orderList   : définit la collections des commandes
 */

public class DataAccess {
    /**
     * Collection qui gère la list des produits
     */
    private  List<Product> productList = new ArrayList<Product>();

    /**
     * Collection qui gère la list des offres promotionnelles sur les produits
     */
    private  List<OfferRule> offerRules = new ArrayList<OfferRule>();

    /**
     * Collection qui gère la list des commandes
     */
    private  List<Order> orderList = new ArrayList<Order>();

    /**
     * l'appel du contructeur sans paramètre de la classe DataAccess
     * déclenche l'initialisation de produits, commandes et offre
     * promotionnnelles
     */
    public DataAccess() {
        buildData();
    }

    /**
     * Renvoie la liste des produits
     *
     * @return productList
     */
    public List<Product> getProductList() {

        return productList;
    }


    /**
     * Renvoie la liste des offres promotionnelles
     *
     * @return offerRules
     */
    public List<OfferRule> getOfferRules() {

        return offerRules;
    }

    /**
     * Renvoie la liste des commandes
     *
     * @return orderList
     */
    public List<Order> getOrderList() {

        return orderList;
    }

    /**
     * Cette méthode va permmettre de simuler une base de données
     * à partir des collections. elles contruits et charge les collections
     */

    private void buildData() {

        /**
         *Initialisation des produits
         */
        Product productA = new Product("A", 65, 0, false);
        Product productB = new Product("", 65, 0, false);
        Product productC = new Product("A", 65, 100, true);

        productList.add(productA);
        productList.add(productB);
        productList.add(productC);

        /**
         * initialisation des offres promotionnelles
         */

        offerRules.add(new OfferRule(productA.getName(), 3, 1));
        offerRules.add(new OfferRule(productB.getName(), 3, 1));
        offerRules.add(new OfferRule(productC.getName(), 3, 1));

        /**
         * initialisation des commandes
         */

        orderList.add(new Order(productA, 10));
        orderList.add(new Order(productB, 5));
        orderList.add(new Order(productA, 10));
        orderList.add(new Order(productC, 4));

    }
}
