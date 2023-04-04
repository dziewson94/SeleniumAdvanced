package com.sii.sup.seleniumadavanced.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePageObject {
    private static final Logger logger = LoggerFactory.getLogger(TablePageObject.class.getSimpleName());

    private final WebElement table;
    private final List<TableRowPageObject> rows = new ArrayList<>();

    public TablePageObject(WebElement table) {
        this.table = table;
        getTableRows();
    }

    public List<TableRowPageObject> getRows() {
        return rows;
    }

    private void getTableRows() {
        List<WebElement> tableRowsWebElements = table.findElements(By.tagName("tr"));
        logger.info(String.format("Initializing table object container. Found %d rows.", tableRowsWebElements.size() - 1));
        for (int i = 2; i < tableRowsWebElements.size() ;i++) {
            WebElement tableRowWebElement = tableRowsWebElements.get(i);
            int rank = Integer.parseInt(tableRowWebElement.findElement(By.tagName("th")).getText());
            List<WebElement> cells = tableRowWebElement.findElements(By.tagName("td"));
            rows.add(new TableRowPageObject(rank, cells.get(0).getText(), cells.get(1).getText(), cells.get(2).getText(), Integer.parseInt(cells.get(3).getText())));
        }
    }

    public WebElement getTable() {
        return table;
    }

    public int getRowCount() {
        return rows.size();
    }

    public int getColumnCount() {
        return table.findElements(By.tagName("th")).size();
    }

    public WebElement getCellElement(int row, int column) {
        return table.findElement(By.xpath("//tr[" + row + "]/td[" + column + "]"));
    }
}