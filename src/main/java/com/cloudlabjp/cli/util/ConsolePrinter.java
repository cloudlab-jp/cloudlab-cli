package com.cloudlabjp.cli.util;

public final class ConsolePrinter {

    private ConsolePrinter() {
    }

    public static void info(String message) {
        System.out.println(message);
    }

    public static void success(String message) {
        System.out.println("✔ " + message);
    }

    public static void error(String message) {
        System.err.println("✖ " + message);
    }

}