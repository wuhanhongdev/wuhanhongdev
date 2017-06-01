package com.dev.design.factory.abstractFactory.factory;


import com.dev.design.factory.abstractFactory.button.Button;
import com.dev.design.factory.abstractFactory.button.SpringButton;
import com.dev.design.factory.abstractFactory.textfield.SpringTextField;
import com.dev.design.factory.abstractFactory.textfield.TextField;

public class SpringFactory implements Factory{
    public Button createButton() {
        return new SpringButton();
    }

    public TextField createTextField() {
        return new SpringTextField();
    }
}
