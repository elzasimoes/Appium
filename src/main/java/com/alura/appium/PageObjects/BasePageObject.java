package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;

public abstract class BasePageObject {

    protected final AppiumDriver driver;

    protected BasePageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public abstract void BuscarElementos();
}
