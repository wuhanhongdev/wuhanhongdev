package com.dev.design.factory.simple;

public class ProductFactory {

    public static Product instance(PeoductType type){
        switch (type){
            case A:
                return new ProductTypeA();
            case B:
                return new ProductTypeB();
            case C:
                return new ProductTypeC();
            default:
                return null;
        }
    }
}
