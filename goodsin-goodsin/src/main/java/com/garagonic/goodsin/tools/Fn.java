package com.garagonic.goodsin.tools;

public class Fn {

    public static boolean isStringPopulated(String value) {
      return !isStringEmpty(value);
    }

    public static boolean isStringEmpty(String value) {
        return value == null || "".equals(value);
    }
}
