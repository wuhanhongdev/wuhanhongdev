package com.dev.design.factory.normal;

public class TypeCProductFactory implements ProductFactory {
    public Product createProductFactory() {
        return  new ProductTypeC();
    }
}
