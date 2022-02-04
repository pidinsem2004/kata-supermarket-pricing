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


    /**
     * Test case
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
     * Test case
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
     * Test case
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
     * Test case
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
     * Test case
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




}
