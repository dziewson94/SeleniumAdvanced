package com.sii.sup.seleniumadavanced.utils;
 public class FactoryHelper {
    FactoryHelper(){}
    public WebDriverFactory getWebDriverFactory() {
        return new WebDriverFactory();
    }

    public UserFactory getUserFactory() {
        return new UserFactory();
    }
}
