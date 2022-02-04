package kata.dev.entities;


/**
 * Cette classe va permettre de gérer les produits
 * disponibles dans le stock du supermarché. Un example de
 * produit est une louche de table, une serviette....les promotions
 * peuvent s'appliquer à certains produits du supermùarché
 * <p>
 * Un produit est défini par:
 * name  : la désignation du produit
 * price : le prix unitaire de détail du produit
 * availableQuantity : la quantité du produit disponible dans le stock
 * isOffered : permet de savoir si le produit est soumis ou non à une
 * offre promotionnelle
 *
 * @author Jean Pierre NSEM
 */

public class Product {
    /**
     * le nom du produit
     */
    private String name;
    /**
     * Le prix unitaire de détail du produit
     */
    private int price;
    /**
     * la quantité disponible en stock
     */
    private int availableQuantity;
    /**
     * indique si le produit est soumis ou pas à une offre promotionnelle
     */
    private boolean isOffered;


    /**
     * construit une produit vide
     */
    public Product() {
    }

    /**
     * Construit une commande avec les paramlètres
     *
     * @param name              le nom produit
     * @param availableQuantity la quantité disponible en stock
     * @param price             : le prix unitaire de détail du produit
     * @param isOffered         : indique si le produit est en promotion ou non
     */
    public Product(String name, int price, int availableQuantity, boolean isOffered) {
        this.name = name;
        this.price = price;
        this.isOffered = isOffered;
        this.availableQuantity = availableQuantity;
    }

    /**
     * Renvoie le nom du produit
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * assigne le nom  passé en paramètre à l'objet produit en cours
     *
     * @param name le produit du produit
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Renvoie le prix unitaire de détail du produit
     *
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * assigne le prix  passé en paramètre à l'objet produit en cours
     *
     * @param price le prix unitaire de détail du produit
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Renvoie true si le produit est en promotion, false sinon
     *
     * @return isOffered
     */
    public boolean isOffered() {
        return isOffered;
    }

    /**
     * assigne true si le produit est en promotion ou false sinon ,  à l'objet produit en cours
     *
     * @param offered true ou false
     */
    public void setOffered(boolean offered) {
        isOffered = offered;
    }

    /**
     * Renvoie la quantité du produit disponible en stock
     *
     * @return availableQuantity
     */
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    /**
     * assigne la quantié  passé en paramètre à l'objet produit en cours
     *
     * @param availableQuantity la quantité de produit disponible
     */
    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    /**
     * Cette méthode renvoie une chaîne qui est une "représente textuellement"
     * de l'objet de la classe Product. Le résultat est concis et donne suffisamment
     * d'information sur l'objet et facile à lire par les personnes.
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", availableQuantity=" + availableQuantity +
                ", isOffered=" + isOffered +
                '}';
    }
}
