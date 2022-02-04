package kata.dev.entities;


/**
 * Cette classe va permettre de gérer les commandes
 * effectuées par les clients du supermarché. Un client
 * pourra en fonction de ses besoins passer une ou plusieurs
 * commandes.
 * Une commande est définie par:
 * orderProduct : le produit commandé
 * orderQuantity : la quantité associée au produit commandé
 *
 * @author Jean Pierre NSEM
 */

public class Order {

    /**
     * produit de la commande
     */
    private Product orderProduct;

    /**
     * Quantité de produit(s) commandée
     */
    private int orderQuantity;

    /**
     * Construit une commande vide .
     */
    public Order() {
    }

    /**
     * Construit une commande avec les paramlètres
     *
     * @param orderProduct  le produit
     * @param orderQuantity la quantité commandée
     */
    public Order(Product orderProduct, int orderQuantity) {
        this.orderProduct = orderProduct;
        this.orderQuantity = orderQuantity;
    }

    /**
     * Renvoie le produit
     *
     * @return Produit
     */
    public Product getOrderProduct() {
        return orderProduct;
    }

    /**
     * assigne le produit  passé en paramètre à l'objet commande en cours
     *
     * @param orderProduct le produit de la commande
     */

    public void setOrderProduct(Product orderProduct) {
        this.orderProduct = orderProduct;
    }

    /**
     * Renvoie la quantité
     *
     * @return la quantité
     */
    public int getOrderQuantity() {
        return orderQuantity;
    }

    /**
     * assigne la quantité passée en paramètre à l'objet commande en cours
     *
     * @param orderQuantity la quantité du produit commandé
     */

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    /**
     * Cette méthode renvoie une chaîne qui est une "représente textuellement"
     * de l'objet de la classe Order. Le résultat est concis et donne suffisamment
     * d'information sur l'objet et facile à lire par les personnes.
     */
    @Override
    public String toString() {
        return "Order{" +
                "orderProduct=" + orderProduct +
                ", orderQuantity=" + orderQuantity +
                '}';
    }
}
