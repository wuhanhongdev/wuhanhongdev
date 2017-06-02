package com.dev;


import com.dev.design.factory.abstractFactory.button.Button;
import com.dev.design.factory.abstractFactory.factory.Factory;
import com.dev.design.factory.abstractFactory.factory.SpringFactory;
import com.dev.design.factory.normal.Product;
import com.dev.design.factory.normal.ProductFactory;
import com.dev.design.factory.normal.TypeAProductFactory;
import org.junit.Test;

public class AppTest {

    @Test
    public void testSimpleFactory(){
        /*ProductFactory factory = new TypeAProductFactory();
        Product product = factory.createProductFactory();
        product.print();*/
        Factory factory = new SpringFactory();
        Button button = factory.createButton();
        button.print();
    }
}
