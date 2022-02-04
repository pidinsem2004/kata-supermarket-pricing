package kata.dev;

import kata.dev.dao.DataAccess;
import kata.dev.entities.OfferRule;
import kata.dev.entities.Order;
import kata.dev.entities.Product;
import kata.dev.service.IOrder;
import kata.dev.service.NormalOrder;
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


    /**
     * Test case 1
     * The product quantity in stock is null, throw exception
     *
     * @throws RuntimeException if the product quantity is null
     *                          or not defined
     */
    @Test
    public void theProductQuantityInStockIsNullThrowException() {
        exception.expect(RuntimeException.class);
        theProductQuantityInStockIsNullThrowExceptionImpl(productList.get(0));

    }


    /**
     * Implementation of the Test case
     * The product quantity in stock is null, throw exception
     *
     * @throws RuntimeException if the product quantity is null
     *                          or not defined
     */
    public void theProductQuantityInStockIsNullThrowExceptionImpl(Product product) {

        if (product.getAvailableQuantity() == 0)
            throw new RuntimeException("The Product quabtity is undefined");
    }


    /**
     * Test case 2
     * product should have a name, otherwise throw an exception
     *
     * @throws RuntimeException
     */
    @Test
    public void theProductNameIsNullOrEmptyThenThrowException() {
        exception.expect(RuntimeException.class);
        theProductNameIsNullOrEmptyImpl(productList.get(1));
    }

    /**
     * Implementation
     * product should have a name, otherwise throw an exception
     *
     * @throws RuntimeException
     */
    public void theProductNameIsNullOrEmptyImpl(Product product) {

        if (product.getName() == null || product.getName() == "")
            throw new RuntimeException("The Product Name Should not be null or empty");
    }


    /**
     * Test case 3
     * if two product with same name in stock, throw an exception
     *
     * @throws RuntimeException
     */
    @Test
    public void twoProductInStockWithTheSameNameThrowException() {
        exception.expect(RuntimeException.class);
        assertTrue(twoProductInStockWithTheSameNameImpl(productList.get(0), productList.get(2)));
    }

    /**
     * Implementation
     * if two product with same name in stock, throw an exception
     *
     * @throws RuntimeException
     */
    public boolean twoProductInStockWithTheSameNameImpl(Product p1, Product p2) {

        if (p1.getName().equalsIgnoreCase(p2.getName()))
            throw new RuntimeException("The product name should be unique");
        return true;
    }


    /**
     * Test case 4
     * An order should have at least one product, if not exception is throw
     *
     * @throws RuntimeException
     */
    @Test
    public void oderWithNoProduct() {
        exception.expect(RuntimeException.class);
        orderList.clear();
        oderWithNoProductImpl(orderList);
    }

    /**
     * Implementation
     * An order should have at least one product, if not exception is throw
     *
     * @throws RuntimeException
     */
    public void oderWithNoProductImpl(List<Order> orderList) {

        if (orderList.size() == 0)
            throw new RuntimeException("An order should have at least one product");
    }


    /**
     * Test case 5
     * order unavailable product in stock, Throw exception
     *
     * @throws RuntimeException
     */
    @Test
    public void unavailableProductInStockThrowException() {
        exception.expect(RuntimeException.class);
        Order order = new Order(productList.get(1), 10);
        unavailableProductInStockThrowExceptionImpl(order);

    }

    /**
     * Implementation
     * order unavailable product in stock, Throw exception
     *
     * @throws RuntimeException
     */
    public void unavailableProductInStockThrowExceptionImpl(Order order) {

        if (order.getOrderProduct().getAvailableQuantity() == 0)
            throw new RuntimeException("Unavailable product in Stock");
    }


    /**
     * Test case 6
     * product quantity in order should be greater than 0
     *
     * @throws RuntimeException
     */
    @Test
    public void productQuantityInOrderShouldBeGreaterThanZero() {
        exception.expect(RuntimeException.class);
        Order order = new Order(productList.get(1), 0);
        productQuantityInOrderShouldBeGreaterThanZeroImpl(order);
    }

    /**
     * Implementation
     * product quantity in order should be greater than 0
     *
     * @throws RuntimeException
     */
    public void productQuantityInOrderShouldBeGreaterThanZeroImpl(Order order) {

        if (order.getOrderQuantity() == 0)
            throw new RuntimeException("Non Authorized null quantity");
    }


    /**
     * Test case 7
     * Adding pricing rule without product name, throw exception;
     *
     * @throws RuntimeException
     */
    @Test
    public void pricingRuleWithoutProductThrowException() {
        exception.expect(RuntimeException.class);
        OfferRule or = new OfferRule();
        or.setQuantity(10);
        or.setOfferPrice(50);
        pricingRuleWithoutProductThrowExceptionImpl(or);

    }

    /**
     * Implementation
     * Adding pricing rule without product name, throw exception;
     *
     * @throws RuntimeException
     */
    public void pricingRuleWithoutProductThrowExceptionImpl(OfferRule or) {
        if (or.getProductName().equalsIgnoreCase("") || or.getProductName() == null)
            throw new RuntimeException("Invalid Offer Rule without product name ");

    }


    /**
     * Test case 8
     * Adding pricing Rule without quantity, throw exception;
     *
     * @throws RuntimeException
     */
    @Test
    public void addingPricingRuleWithoutQuantityThrowException() {

        exception.expect(RuntimeException.class);
        OfferRule or = new OfferRule();
        or.setProductName(productList.get(0).getName());
        or.setOfferPrice(50);
        addingPricingRuleWithoutQuantityThrowException(or);
    }

    /**
     * Implementation
     * Adding pricing Rule without quantity, throw exception;
     *
     * @throws RuntimeException
     */
    public void addingPricingRuleWithoutQuantityThrowException(OfferRule or) {

        if (or.getQuantity() == 0)
            throw new RuntimeException("Invalid Offer Quantity");
    }


    /**
     * Test case 9
     * Adding pricing rule without special price, throw an exception;
     *
     * @throws RuntimeException
     */
    @Test
    public void addingPricingRuleWithoutSpecialPriceThrowException() {
        exception.expect(RuntimeException.class);
        OfferRule or = new OfferRule();
        or.setQuantity(10);
        or.setProductName(productList.get(0).getName());
        addingPricingRuleWithoutSpecialPriceThrowExceptionImpl(or);
    }

    /**
     * Implementation
     * Adding pricing rule without special price, throw an exception;
     *
     * @throws RuntimeException
     */
    public void addingPricingRuleWithoutSpecialPriceThrowExceptionImpl(OfferRule or) {
        if (or.getOfferPrice() == 0)
            throw new RuntimeException("Invalid offer price");
    }


    /**
     * Test case 10
     * Adding pricing rule to the product
     *
     * @throws RuntimeException
     */
    @Test
    public void AddingPricingRule() {
        offerRuleList.clear();
        OfferRule or = new OfferRule();
        or.setProductName(productList.get(0).getName());
        or.setQuantity(10);
        or.setOfferPrice(50);
        offerRuleList.add(or);
        assertEquals(1, AddingPricingRuleImpl(offerRuleList));

    }

    /**
     * Implementation
     * Adding pricing rule to the product
     *
     * @throws RuntimeException
     */
    public int AddingPricingRuleImpl(List<OfferRule> offerRuleList) {
        return offerRuleList.size();
    }


    /**
     * test case 10
     * Checkout Order Without Special Offer
     *
     * @throws RuntimeException
     */
    @Test
    public void checkoutOrderWithoutSpecialOffer() {
        orderList.clear();
        Order o = new Order();
        o.setOrderProduct(new Product("orange", 20, 100, false));
        o.setOrderQuantity(20);
        orderList.add(o);
        assertEquals(400, checkoutOrderWithoutSpecialOfferImpl(orderList));
    }

    /**
     * Implementation
     * Checkout Order Without Special Offer
     *
     * @throws RuntimeException
     */
    public int checkoutOrderWithoutSpecialOfferImpl(List<Order> orderList) {
        IOrder<Order> order = new NormalOrder();
        return order.checkout(orderList, null);
    }






}
