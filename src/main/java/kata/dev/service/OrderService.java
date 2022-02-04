package kata.dev.service;

import kata.dev.dao.DataAccess;
import kata.dev.entities.Order;

import java.util.List;


/**
 * Cette Classe offre le service de gestion des commandes. A partir
 * d'ici,l'utilisateur à la possibilité d'ajouter de nouvelles commandes,
 * de récupérer la liste des commandes passées
 * getOrders() : renvois la liste des produits
 * setProducts() : définit la liste des produits
 * addProduct(Product product) : ajoute un produit à la collection
 *
 * @author Jean Pierre NSEM
 */

public class OrderService {

    /**
     * Initialisation de la liste des commandes
     */
    private List<Order> orders = new DataAccess().getOrderList();


    /**
     * Renvoie la listes des commandes
     *
     * @return orders
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * assigne la liste des commandes passée en paramètre
     *
     * @param orders
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    /**
     * Ajoute une commande à la liste
     *
     * @param order : la commande
     * @throws RuntimeException lève une exception dans l'un des cas suivant :
     *                          - la commande null
     *                          - le nom du produit est vide ou null
     *                          - la quantité commandée est 0
     */
    public void addOrder(Order order) {
        if (order == null || order.getOrderProduct() == null || order.getOrderProduct().getName() == null || order.getOrderProduct().getName() == "" || order.getOrderQuantity() == 0)
            throw new RuntimeException("Invalid Order ");
        else
            orders.add(order);
    }
}
