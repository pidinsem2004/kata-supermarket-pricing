package kata.dev.service;

import kata.dev.dao.DataAccess;
import kata.dev.entities.OfferRule;

import java.util.List;

/**
 * Cette Classe offre le service de gestion des promotions. A partir
 * d'ici,l'utilisateur à la possibilité d'ajouter de nouvelles offres promotionnelles
 * sur les produits, de récupérer la liste des promotions
 * getOfferRules() : renvois la liste des offres
 * setOfferRules() : définit la liste des offres
 * addOfferRule(OfferRule offerRule) : ajoute une offre promotionnelle à la liste
 *
 * @author Jean Pierre NSEM
 */
public class OfferRuleService {

    /**
     * Initialisation de la liste des offres promotionnelles
     */
    private List<OfferRule> offerRules = new DataAccess().getOfferRules();


    /**
     * Renvoie la listes des offres
     *
     * @return offerRules
     */
    public List<OfferRule> getOfferRules() {
        return offerRules;
    }

    /**
     * assigne la liste des offres passées en paramètre
     *
     * @param offerRules
     */
    public void setOfferRules(List<OfferRule> offerRules) {
        this.offerRules = offerRules;
    }


    /**
     * Ajoute une offre à la liste
     *
     * @param offerRule : l'offre promotionnelle
     * @throws RuntimeException lève une exception si
     *                          - l'offre est null
     *                          - le produit de l'offre est vide ou non défini
     *                          - le prix de l'offre est 0 ou non défini
     */
    public void addOfferRule(OfferRule offerRule) {
        if (offerRule == null || offerRule.getProductName() == null || offerRule.getProductName() == "" || offerRule.getOfferPrice() == 0)
            throw new RuntimeException("invalid Offer rule");
        else
            offerRules.add(offerRule);
    }
}
