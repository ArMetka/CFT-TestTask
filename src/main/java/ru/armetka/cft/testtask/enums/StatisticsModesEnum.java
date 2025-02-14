package ru.armetka.cft.testtask.enums;

public enum StatisticsModesEnum {
    SHORT("s"),
    FULL("f");

    private final String title;

    StatisticsModesEnum(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
