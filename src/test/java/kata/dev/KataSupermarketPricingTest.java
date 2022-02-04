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


}
