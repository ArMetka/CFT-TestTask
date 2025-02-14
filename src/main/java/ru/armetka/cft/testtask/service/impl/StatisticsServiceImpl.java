package ru.armetka.cft.testtask.service.impl;

import ru.armetka.cft.testtask.entity.Statistics;
import ru.armetka.cft.testtask.enums.StatisticsModesEnum;
import ru.armetka.cft.testtask.service.StatisticsService;
import ru.armetka.cft.testtask.storage.ParsedDataStorage;

public class StatisticsServiceImpl implements StatisticsService {
    private final ParsedDataStorage storage;

    public StatisticsServiceImpl(ParsedDataStorage storage) {
        this.storage = storage;
    }

    @Override
    public Statistics generateStatistics(StatisticsModesEnum mode) {
        return null;
    }

    // TODO: move to output service
    @Override
    public void printStatistics(StatisticsModesEnum mode) {
        System.out.println(this.storage.getLongList());
        System.out.println(this.storage.getDoubleList());
        System.out.println(this.storage.getStringList());
    }
}
