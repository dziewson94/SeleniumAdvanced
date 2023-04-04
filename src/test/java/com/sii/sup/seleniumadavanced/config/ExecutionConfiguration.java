package com.sii.sup.seleniumadavanced.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExecutionConfiguration {

    public static final BrowserConfig browserConfigs = initBrowserConfig();



    private static BrowserConfig initBrowserConfig() {
        BrowserConfig browserConfig;
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = new File(Objects.requireNonNull(ExecutionConfiguration.class.getClassLoader().getResource("configuration/browser/browsers.yaml")).getFile());
        try {
            browserConfig = mapper.readValue(file, BrowserConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return browserConfig;
    }
    public static BrowserConfig.Browser getBrowserConfig(BrowserName browserName) {
        return browserConfigs.getBrowsers().get(browserName.name().toLowerCase());
    }
}
