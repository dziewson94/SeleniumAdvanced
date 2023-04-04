package com.sii.sup.seleniumadavanced.config;

import java.util.List;
import java.util.Map;

public class BrowserConfig {
    private BrowserConfig() {}
    private Map<String, Browser> browsers;

    public Map<String, Browser> getBrowsers() {
        return browsers;
    }

    public void setBrowsers(Map<String, Browser> browsers) {
        this.browsers = browsers;
    }

    public static class Browser {
        private Browser(){}
        private String name;
        private String window;
        private List<String> options;
        private Map<String, Object> prefs;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWindow() {
            return window;
        }

        public void setWindow(String window) {
            this.window = window;
        }

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> options) {
            this.options = options;
        }

        public Map<String, Object> getPrefs() {
            return prefs;
        }

        public void setPrefs(Map<String, Object> prefs) {
            this.prefs = prefs;
        }
    }
}
