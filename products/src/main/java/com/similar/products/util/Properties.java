package com.similar.products.util;

public enum Properties {
    BASE_URL("base.url");
    private final String key;

    Properties(String key) { this.key = key; }

    public String getKey() {
        return key;
    }
}
