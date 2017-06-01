package com.dev.design.factory.abstractFactory.factory;

import com.dev.design.factory.abstractFactory.button.Button;
import com.dev.design.factory.abstractFactory.textfield.TextField;

public interface Factory {
    Button createButton();
    TextField createTextField();
}
