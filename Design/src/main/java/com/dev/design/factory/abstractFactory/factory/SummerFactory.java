package com.dev.design.factory.abstractFactory.factory;

import com.dev.design.factory.abstractFactory.button.Button;
import com.dev.design.factory.abstractFactory.button.SummerButton;
import com.dev.design.factory.abstractFactory.textfield.SummerTextField;
import com.dev.design.factory.abstractFactory.textfield.TextField;

public class SummerFactory implements Factory {
    public Button createButton() {
        return new SummerButton();
    }

    public TextField createTextField() {
        return new SummerTextField();
    }
}
