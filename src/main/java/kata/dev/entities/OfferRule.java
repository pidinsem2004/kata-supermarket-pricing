package kata.dev.entities;

/**
 * Cette classe va permettre de gérer les offres
 * promotionnelles sur les différents produits
 * disponibles dans le stock du supermarché. Un example d'offre
 * promotionnelle serait de bénéficier d'un produit en plus
 * après l'achat de 2 produits au prix de détail
 * Une offre est définie par:
 * productName : le nom dju produit sur lequel s'applique
 * l'offre promotionnelle
 * quantity : la quantité associée à l'offre
 * offerPrice : le prix associé à l'offre
 *
 * @author Jean Pierre NSEM
 */


public class OfferRule {

    /**
     * Nom du produit
     */

    private String productName;

    /**
     * La quantité
     */
    private int quantity;

    /**
     * le prix associé
     */
    private int offerPrice;


    /**
     * Construit une offre vide .
     */

    public OfferRule() {
    }

    /**
     * Construit une offre promotionnelle à partir des valeurs
     * passées en paramètres
     *
     * @param productName le nom du produit
     * @param quantity    la quantité associée à l'offre
     * @param offerPrice  le prix de l'offre
     */

    public OfferRule(String productName, int quantity, int offerPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.offerPrice = offerPrice;

    }

    /**
     * Renvoie le nom du produit
     *
     * @return nom du produit
     */
    public String getProductName() {
        return productName;
    }

    /**
     * assigne le nom du produit passée en paramètre à l'objet offerRule en cours
     *
     * @param productName le nom du produit
     */

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Renvoie la quantité du produit
     *
     * @return quantité
     */
    public int getQuantity() {
        return quantity;
    }


    /**
     * assigne la quantité passée en paramètre à l'objet offerRule en cours
     *
     * @param quantity quantité de produit
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Renvoie le prix ce l'offre promotionnelle
     *
     * @return prix de l'offre promotionnelle
     */

    public int getOfferPrice() {
        return offerPrice;
    }


    /**
     * assigne le prix passé en paramètre à l'objet offerRule en cours
     *
     * @param offerPrice le prix associé à l'offre promotionnelle
     */
    public void setOfferPrice(int offerPrice) {
        this.offerPrice = offerPrice;
    }

    /**
     * Cette méthode renvoie une chaîne qui est une "représente textuellement"
     * de l'objet de la classe OfferRule. Le résultat est concis et donne suffisamment
     * d'information sur l'objet et facile à lire par les personnes
     */

    @Override
    public String toString() {
        return "OfferRule{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", offerPrice=" + offerPrice +
                '}';
    }
}


