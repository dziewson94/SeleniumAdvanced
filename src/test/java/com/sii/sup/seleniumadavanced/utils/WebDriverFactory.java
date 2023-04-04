package com.sii.sup.seleniumadavanced.utils;

import com.sii.sup.seleniumadavanced.config.BrowserConfig;
import com.sii.sup.seleniumadavanced.config.BrowserName;
import com.sii.sup.seleniumadavanced.config.ExecutionConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverFactory {
    WebDriverFactory(){};
    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class.getSimpleName());

    public WebDriver getWebDriverForBrowser(BrowserName browserName) {

        switch (browserName) {
            case CHROME -> {
                return getChromeBrowserWebDriver();
            }
            case FIREFOX -> {
                logger.info("Maybe someday");
            }
        }

        return null;
    }

    private void setWindowSize(String windowSize, WebDriver webDriver) {
        if (windowSize.equals("maximize")) {
            webDriver.manage().window().maximize();

        }
        logger.info("Browser window size is set to:" + windowSize);
    }

    public WebDriver getChromeBrowserWebDriver() {
        logger.info("Initializing chrome browser web engine");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        BrowserConfig.Browser browser = ExecutionConfiguration.getBrowserConfig(BrowserName.CHROME);
        browser.getOptions().forEach(options::addArguments);
        logger.info("Chrome options:");
        browser.getOptions().forEach(logger::info);
        options.setExperimentalOption("prefs", browser.getPrefs());
        logger.info("Chrome experimental options:");
        browser.getPrefs().entrySet().stream().map(entry -> String.format("%s: %s", entry.getKey(), entry.getValue())).forEach(logger::info);
        WebDriver webDriver = new ChromeDriver(options);
        setWindowSize(browser.getWindow(), webDriver);
        return webDriver;
    }
}
