package com.cloudlabjp.cli.util;

public final class StringUtils {

    private StringUtils() {
    }

    public static String capitalize(String value) {

        if (value == null || value.isBlank()) {
            return value;
        }

        return value.substring(0, 1).toUpperCase() + value.substring(1);

    }

}