package ru.armetka.cft.testtask.enums;

public enum OptionsListEnum {
    OUTPUT_PATH ("o"),
    OUTPUT_PREFIX ("p"),
    APPEND_MODE ("a"),
    STATISTICS_SHORT (StatisticsModesEnum.SHORT.toString()),
    STATISTICS_FULL (StatisticsModesEnum.FULL.toString());

    private final String title;

    OptionsListEnum(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
