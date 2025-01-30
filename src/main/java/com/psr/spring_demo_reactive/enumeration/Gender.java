package com.psr.spring_demo_reactive.enumeration;

public enum Gender {
    MALE, FEMALE;

    public static Gender fromOrdinal(int ordinal) {
        return values()[ordinal];
    }
}