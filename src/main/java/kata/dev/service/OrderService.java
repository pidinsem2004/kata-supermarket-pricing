package kata.dev.service;

import kata.dev.dao.DataAccess;
import kata.dev.entities.OfferRule;
import kata.dev.entities.Order;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders   = new DataAccess().getOrderList();


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order){
        if (order==null || order.getOrderProduct()==null || order.getOrderProduct().getName()==null || order.getOrderProduct().getName()=="" || order.getOrderQuantity()==0)
            throw  new RuntimeException("Invalid Order ");
        else
            orders.add(order);
    }

    //this function determine the total price, no Special Pricing defined
    public static int  checkout(List<Order> orders){

        /*int total  = 0;
        Iterator  iterator =  orders.iterator();
        while(iterator.hasNext()){
            Order  o  = (Order) iterator.next();
            total += o.getOrderQuantity()*o.getOrderProduct().getPrice();
        }
        return total;*/


        LongAdder total  = new LongAdder();
        orders.forEach(o ->{
            total.add(o.getOrderQuantity()*o.getOrderProduct().getPrice());
        });
        return  Integer.parseInt(""+total)  ;

    }


    public static  void main (String...args){

    }

    // predicate to filter the duplicates by the given key extractor.
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> uniqueMap = new ConcurrentHashMap<>();
        return t -> uniqueMap.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static int checkout(List<Order> orderList, List<OfferRule> offerRuleList) {

        LongAdder longAdder = new LongAdder();

        List<Order> d_OderList = orderList.stream().filter(distinctByKey( order -> order.getOrderProduct().getName())).collect(Collectors.toList());

        d_OderList.forEach( o -> {

            int total_price=0;
             // see if there is Offer rule for the order
            List<OfferRule> offerRules =  offerRuleList.stream().filter( or ->
             or.getProductName().equalsIgnoreCase(o.getOrderProduct().getName())
            ).collect(Collectors.toList());

            int currentOderNumber =0;
            if(offerRules==null || offerRules.size()==0){
                //no offer : apply normal price
                //get the number of ordered product
                  currentOderNumber = orderList
                        .stream()
                        .filter( order -> order.getOrderProduct().getName()
                        .equalsIgnoreCase(o.getOrderProduct().getName()))
                        .mapToInt(i->i.getOrderQuantity())
                        .sum();
                total_price = o.getOrderProduct().getPrice() * currentOderNumber;
                longAdder.add(total_price);

            } else {
                //there is a offer rule for the product
                OfferRule  offerRule = offerRules.get(0);

                //get the number of ordered product
                currentOderNumber = orderList
                        .stream()
                        .filter( order -> order.getOrderProduct().getName()
                        .equalsIgnoreCase(offerRule.getProductName()))
                        .mapToInt(i->i.getOrderQuantity())
                        .sum();

                //number of current order set and remaining part
                int q = currentOderNumber/offerRule.getQuantity();
                int r = currentOderNumber%offerRule.getQuantity();
                 total_price = q * offerRule.getOfferPrice() + r * o.getOrderProduct().getPrice();
                 longAdder.add(total_price);
             }
        });

        return Integer.parseInt(""+longAdder);
    }



}
