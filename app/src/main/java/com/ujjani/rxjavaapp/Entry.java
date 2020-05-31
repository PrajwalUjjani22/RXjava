package com.ujjani.rxjavaapp;

public class Entry {

    private final String entryName;
    private final String entryPrice;
    private final String entryDate;


    public Entry(String entryName, String entryPrice, String entryDate) {
        this.entryName = entryName;
        this.entryPrice = entryPrice;
        this.entryDate = entryDate;
    }

    public String getEntryName() {
        return entryName;
    }

    public String getEntryPrice() {
        return entryPrice;
    }

    public String getEntryDate() {
        return entryDate;
    }
}
