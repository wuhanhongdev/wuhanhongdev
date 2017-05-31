package com.dev;

import com.dev.design.factory.simple.PeoductType;
import com.dev.design.factory.simple.Product;
import com.dev.design.factory.simple.ProductFactory;
import org.junit.Test;

public class AppTest {

    @Test
    public void testSimpleFactory(){
        Product product = ProductFactory.instance(PeoductType.C);
        product.print();
    }
}
