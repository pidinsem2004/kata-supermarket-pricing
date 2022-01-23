package kata.dev;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
import static  org.junit.Assert.*;

public class KataSupermarketPricingTest {


    private KataSupermarketPricing kataSupermarketPricing = new KataSupermarketPricing() ;

    @Test
    public  void TestPositivePrice (){

        assertEquals(true, KataSupermarketPricing.isPricePositive(1));

    }

}
