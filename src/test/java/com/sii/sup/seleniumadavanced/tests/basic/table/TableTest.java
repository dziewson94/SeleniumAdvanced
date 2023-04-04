package com.sii.sup.seleniumadavanced.tests.basic.table;


import com.sii.sup.seleniumadavanced.pageobject.HomePage;
import com.sii.sup.seleniumadavanced.pageobject.TablePage;
import com.sii.sup.seleniumadavanced.pageobject.TableRowPageObject;
import com.sii.sup.seleniumadavanced.tests.base.TestBase;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TableTest.class.getSimpleName());

    @Test
    void tableTest() {
        logger.info("Initializing home page object");
        HomePage homePage = new HomePage(webDriver);
        logger.info("Enter table page");
        homePage.enterTablePage();
        logger.info("Initialize table object");

        TablePage tablePage = new TablePage(homePage.getWebDriver());
        logger.info("Print table rows");
        StringBuilder output = new StringBuilder("\n");
        for (TableRowPageObject row : tablePage.getTableRows()) {
            output.append(row.toString()).append("\n");
        }
        logger.info("Table rows: " + output.toString());

        List<TableRowPageObject> filteredList = tablePage.getTableRows().stream().filter(mountain ->
                mountain.state().equals("Switzerland") &&
                        (mountain.height() >
                                4000)
        ).toList();
        if (!filteredList.isEmpty())
            logger.info("Found: " + filteredList.get(0));
        assertThat(tablePage.getRowsCount()).isEqualTo(13);
        assertThat(filteredList).containsAll(expectedRowsList());

    }

    private List<TableRowPageObject> expectedRowsList() {
            List<TableRowPageObject> expectedResult = new ArrayList<>();
            expectedResult.add(new TableRowPageObject(3, "Dom", "Alps", "Switzerland", 4545));
            expectedResult.add(new TableRowPageObject(4, "Weisshorn", "Alps", "Switzerland", 4506));
            expectedResult.add(new TableRowPageObject(6, "Finsteaarhorn", "Alps", "Switzerland", 4274));
            expectedResult.add(new TableRowPageObject(7, "Jungfrau", "Alps", "Switzerland", 4158));
        return expectedResult;


    }


}
