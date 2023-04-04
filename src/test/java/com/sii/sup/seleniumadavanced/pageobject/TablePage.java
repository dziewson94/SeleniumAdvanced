package com.sii.sup.seleniumadavanced.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TablePage {
    @FindBy(className = "table")
    private WebElement tableWebElement;


    private final TablePageObject tablePageObject;

    public TablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.tablePageObject = new TablePageObject(tableWebElement);


    }

    public WebElement getTableWebElement() {
        return tableWebElement;
    }

    public List<TableRowPageObject> getTableRows() {
        return this.tablePageObject.getRows();
    }

    public int getRowsCount() {
        return tablePageObject.getRowCount();
    }
    public void setTableWebElement(WebElement tableWebElement) {
        this.tableWebElement = tableWebElement;
    }
}
