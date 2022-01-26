package kata.dev;

import kata.dev.dao.DataAccess;
import kata.dev.entities.OfferRule;
import kata.dev.entities.Order;
import kata.dev.entities.Product;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KataSupermarketPricingTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private List<Product> productList = new ArrayList<Product>();
    private List<OfferRule> offerRuleList = new ArrayList<OfferRule>();
    private List<Order> orderList = new ArrayList<Order>();
    private KataSupermarketPricing kataSupermarketPricing = new KataSupermarketPricing();


    @Before
    public final void before() {
        DataAccess dao = new DataAccess();
        productList = dao.getProductList();
        offerRuleList = dao.getOfferRules();
        orderList = dao.getOrderList();
    }

    //The product quantity in stock is null, throw exception
    @Test
    public void theProductQuantityInStockIsNullThrowException() {
        exception.expect(RuntimeException.class);
        kataSupermarketPricing.theProductQuantityInStockIsNullThrowException(productList.get(0));

    }

    //Each product should have a name, otherwise throw an exception
    @Test
    public void theProductNameIsNullOrEmptyThenThrowException() {
        exception.expect(RuntimeException.class);
        kataSupermarketPricing.theProductNameIsNullOrEmpty(productList.get(1));
    }


    //if  two product with same name in stock, throw an exception
    @Test
    public void twoProductInStockWithTheSameNameThrowException() {
        exception.expect(RuntimeException.class);
        assertTrue(kataSupermarketPricing.twoProductInStockWithTheSameName(productList.get(0), productList.get(2)));
    }

    //An order should have at least one product, if not exception is throw
    @Test
    public void oderWithNoProduct() {
        exception.expect(RuntimeException.class);
        orderList.clear();
        kataSupermarketPricing.oderWithNoProduct(orderList);
    }

    //order unavailable product in stock, Throw exception
    @Test
    public void unavailableProductInStockThrowException() {
        exception.expect(RuntimeException.class);
        Order order = new Order(productList.get(1), 10);
        kataSupermarketPricing.unavailableProductInStockThrowException(order);

    }

    //product quantity in order should be greater than 0
    @Test
    public void productQuantityInOrderShouldBeGreaterThanZero() {
        exception.expect(RuntimeException.class);
        Order order = new Order(productList.get(1), 0);
        kataSupermarketPricing.productQuantityInOrderShouldBeGreaterThanZero(order);
    }

    //Adding pricing rule without product name, throw exception;
    @Test
    public void pricingRuleWithoutProductThrowException() {
        exception.expect(RuntimeException.class);
        OfferRule or = new OfferRule();
        or.setQuantity(10);
        or.setOfferPrice(50);
        kataSupermarketPricing.pricingRuleWithoutProductThrowException(or);

    }

    //Adding pricing Rule without quantity, throw exception;

    @Test
    public void addingPricingRuleWithoutQuantityThrowException() {

        exception.expect(RuntimeException.class);
        OfferRule or = new OfferRule();
        or.setProductName(productList.get(0).getName());
        or.setOfferPrice(50);
        kataSupermarketPricing.addingPricingRuleWithoutQuantityThrowException(or);
    }


    //Adding pricing rule without special price, throw an exception;
    @Test
    public void addingPricingRuleWithoutSpecialPriceThrowException() {
        exception.expect(RuntimeException.class);
        OfferRule or = new OfferRule();
        or.setQuantity(10);
        or.setProductName(productList.get(0).getName());
        kataSupermarketPricing.addingPricingRuleWithoutSpecialPriceThrowException(or);
    }


    //Adding pricing rule to the product
    @Test
    public void AddingPricingRule() {
        offerRuleList.clear();
        OfferRule or = new OfferRule();
        or.setProductName(productList.get(0).getName());
        or.setQuantity(10);
        or.setOfferPrice(50);
        offerRuleList.add(or);
        assertEquals(1, kataSupermarketPricing.AddingPricingRule(offerRuleList));

    }



    //Checkout Order Without Special Offer
    @Test
    public void checkoutOrderWithoutSpecialOffer() {
        orderList.clear();
        Order o = new Order();
        o.setOrderProduct(new Product("orange", 20, 100, false));
        o.setOrderQuantity(20);
        orderList.add(o);
        assertEquals(400, kataSupermarketPricing.checkoutOrderWithoutSpecialOffer(orderList));
    }

    //Checkout Order : Three cans of beans for 1$
    @Test
    public void checkoutOrderWithThreeCansOfBeansForOnedollar() {
        orderList.clear();
        offerRuleList.clear();
        Order o = new Order(new Product("orange", 20, 100, false), 3);
        orderList.add(o);
        o = new Order(new Product("orange", 20, 100, false), 2);
        orderList.add(o);
        OfferRule or = new OfferRule("orange", 3, 50);
        offerRuleList.add(or);
        assertEquals(90, kataSupermarketPricing.checkoutOrderWithThreeCansOfBeansForOnedollar(orderList, offerRuleList));
    }


    //Checkout Order : by Two Get One for free
    @Test
    public void checkoutOrderWithByTwoGetOneFree() {
        orderList.clear();
        offerRuleList.clear();
        Order o = new Order(new Product("orange", 20, 100, false), 3);
        orderList.add(o);
        o = new Order(new Product("orange", 20, 100, false), 3);
        orderList.add(o);
        OfferRule or = new OfferRule("orange", 3, 40);
        offerRuleList.add(or);
        assertEquals(80, kataSupermarketPricing.checkoutOrderWithByTwoGetOneFree(orderList, offerRuleList));
    }


}
