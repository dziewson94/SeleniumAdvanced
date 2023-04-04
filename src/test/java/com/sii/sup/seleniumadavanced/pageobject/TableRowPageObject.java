package com.sii.sup.seleniumadavanced.pageobject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record TableRowPageObject(int rank, String peak, String mountainRange, String state, int height) {
    private static final Logger logger = LoggerFactory.getLogger(TableRowPageObject.class.getSimpleName());

    public TableRowPageObject(int rank, String peak, String mountainRange, String state, int height) {
        this.rank = rank;
        this.peak = peak;
        this.mountainRange = mountainRange;
        this.state = state;
        this.height = height;
        logger.info(String.format("Found table row containing values:%d,%s,%s,%s,%d", rank, peak, mountainRange, state, height));
    }

    @Override
    public String toString() {
        return "Mountain: " + "rank=" + rank +
                ", peak='" + peak + '\'' +
                ", mountainRange='" + mountainRange + '\'' +
                ", state='" + state + '\'' +
                ", height=" + height;
    }
}