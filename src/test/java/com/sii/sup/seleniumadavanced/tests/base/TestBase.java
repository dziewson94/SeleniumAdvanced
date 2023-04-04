package com.sii.sup.seleniumadavanced.tests.base;

import com.sii.sup.seleniumadavanced.utils.Helper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    public static final String REMOTE_ALLOW_ORIGINS = "--remote-allow-origins=*";
    public static final String DOWNLOAD_PROMPT_FOR_DOWNLOAD = "download.prompt_for_download";
    public static final String DOWNLOAD_DEFAULT_DIRECTORY = "download.default_directory";
    public static final String PREFS = "prefs";
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class.getSimpleName());
    protected WebDriver webDriver;


    @BeforeEach
    public void setup() {
        logger.info("Web driver initialization");
        webDriver = Helper.factoryHelper().getWebDriverFactory().getChromeBrowserWebDriver();
    }


    @AfterEach
    public void tearDown() {
        logger.info("Cleaning up environment");
        webDriver.getWindowHandles().forEach(el -> webDriver.switchTo().window(el).close());


    }
}
