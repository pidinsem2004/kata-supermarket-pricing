package kata.dev.service;

import kata.dev.entities.OfferRule;
import kata.dev.entities.Order;
import kata.dev.utilities.Utility;

import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * Cette classe implémente une stratégie de vente
 * incluant une offre promotionnelle
 *
 * @author Jean Pierre NSEM
 */


public class PromotionalOrder implements IOrder<Order> {
    /*
     * Etant donnée une liste de commande et un ensemble de
     * de promotion sur les produits, cette fonction retourne le prix total
     * @param orderList
     * @param offerRuleList
     * @return totalPrice
     * */
    @Override
    public int checkout(List<Order> orderList, List<OfferRule> offerRuleList) {

        // tatalPrice pour le cumul des montants
        LongAdder totalPrice = new LongAdder();

        // Extraction dans la liste de l'ensembles
        // des produits distincts des commandés
        List<Order> distinct_Oders = orderList.stream().filter(Utility.distinctByKey(order -> order.getOrderProduct().getName())).collect(Collectors.toList());

        distinct_Oders.forEach(o -> {

            //Vérifier si une offre pour le produit en cours de la commande

            OfferRule offerRule = offerRuleList.stream().filter(or ->
                    or.getProductName().equalsIgnoreCase(o.getOrderProduct().getName())
            ).collect(Collectors.toList()).get(0);

            if (offerRule == null) {
                //pas d'offre promotionnelle : appliquer le calcul normal sur toutes les
                //commandes du produit en cours
                List<Order> uniqueProductOnOrderList = orderList.stream()
                        .filter(order -> order.getOrderProduct().getName()
                                .equalsIgnoreCase(o.getOrderProduct().getName())).collect(Collectors.toList());

                NormalOrder normalOrder = new NormalOrder();
                totalPrice.add(normalOrder.checkout(uniqueProductOnOrderList, null));

            } else {


                //le nombre de produit en cours commandé
                int currentProductOderNumber = orderList
                        .stream()
                        .filter(order -> order.getOrderProduct().getName()
                                .equalsIgnoreCase(offerRule.getProductName()))
                        .mapToInt(i -> i.getOrderQuantity())
                        .sum();

                //quantité pour le détail (quotient) et la quantité résiduelle(reste)
                int q = currentProductOderNumber / offerRule.getQuantity();
                int r = currentProductOderNumber % offerRule.getQuantity();

                //Calcul du prix total et cumul
                totalPrice.add(q * offerRule.getOfferPrice() + r * o.getOrderProduct().getPrice());
            }
        });

        return Integer.parseInt("" + totalPrice);
    }
}


