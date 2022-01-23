package kata.dev;

import kata.dev.dao.DataAccess;
import kata.dev.entities.OfferRule;
import kata.dev.entities.Product;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class KataSupermarketPricingTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private List<Product> productList = new ArrayList<Product>();
    private List<OfferRule> offerRuleList = new ArrayList<OfferRule>();
    private KataSupermarketPricing kataSupermarketPricing = new KataSupermarketPricing();


    @Before
    public final void before() {
        DataAccess dao  = new DataAccess();
        productList = dao.getProductList();
        offerRuleList =  dao.getOfferRulesList();

        System.out.println(productList);
        System.out.println(offerRuleList);
    }

    //The product quantity in stock is null, throw exception
    @Test
    public void theProductQuantityInStockIsNullThrowException (){
        exception.expect(RuntimeException.class);
       kataSupermarketPricing.theProductQuantityInStockIsNullThrowException(productList.get(0));

    }

}
