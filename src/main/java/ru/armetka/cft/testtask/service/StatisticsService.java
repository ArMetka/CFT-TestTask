package ru.armetka.cft.testtask.service;

import ru.armetka.cft.testtask.entity.Statistics;
import ru.armetka.cft.testtask.enums.StatisticsModesEnum;

public interface StatisticsService {
    public Statistics generateStatistics(StatisticsModesEnum mode);
}
