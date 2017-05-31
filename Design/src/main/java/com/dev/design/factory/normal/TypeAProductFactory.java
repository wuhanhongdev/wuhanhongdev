package com.dev.design.factory.normal;

public class TypeAProductFactory implements ProductFactory {
    public Product createProductFactory() {
        return  new ProductTypeA();
    }
}
