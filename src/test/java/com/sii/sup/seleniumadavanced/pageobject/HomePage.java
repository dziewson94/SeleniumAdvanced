package com.sii.sup.seleniumadavanced.pageobject;

import com.sii.sup.seleniumadavanced.pageobject.navbar.NavbarButtons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private static final String PAGE_URL = "http://www.seleniumui.moderntester.pl/";
    private WebDriver webDriver;
    @FindBy(how = How.CLASS_NAME, using = "nav-link")
    private List<WebElement> navbarButtons;
    @FindBy(id = "form-item")
    private WebElement formNavButton;
    @FindBy(id = "table-item")
    private WebElement tableNavButton;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(PAGE_URL);
        PageFactory.initElements(webDriver, this);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement getTableNavButton() {
        return tableNavButton;
    }

    public void enterFormPage() {
        getNavbarButton(NavbarButtons.Basic).click();
        getFormNavButton().click();
    }

    public void enterTablePage() {
        getNavbarButton(NavbarButtons.Basic).click();
        getTableNavButton().click();
    }

    public WebElement getFormNavButton() {
        return formNavButton;
    }

    public void setFormNavButton(WebElement formNavButton) {
        this.formNavButton = formNavButton;
    }

    public WebElement getNavbarButton(NavbarButtons navButton) {
        for (WebElement button : navbarButtons) {
            if (button.getText().equals(navButton.name())) {
                return button;
            }
        }
        return navbarButtons.get(0);
    }
}
