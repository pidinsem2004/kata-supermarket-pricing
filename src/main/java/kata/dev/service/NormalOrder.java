package kata.dev.service;

import kata.dev.entities.OfferRule;
import kata.dev.entities.Order;

import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * Cette classe implémente la stratégie de vente normale
 * c'est à dire pas de promotion dans ce cas
 *
 * @author Jean Pierre NSEM
 */


public class NormalOrder implements IOrder<Order> {
    /*
     * Etant donnée une liste de commande, cette fonction retourne
     * le prix total
     * @param orders
     * @return total
     * */
    @Override
    public int checkout(List<Order> orders, List<OfferRule> offerRules) {
        LongAdder total = new LongAdder();
        orders.forEach(o -> {
            total.add(o.getOrderQuantity() * o.getOrderProduct().getPrice());
        });
        return Integer.parseInt("" + total);
    }
}
