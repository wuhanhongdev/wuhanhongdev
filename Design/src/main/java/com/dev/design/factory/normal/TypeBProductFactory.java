package com.dev.design.factory.normal;

public class TypeBProductFactory implements ProductFactory {
    public Product createProductFactory() {
        return  new ProductTypeB();
    }
}
