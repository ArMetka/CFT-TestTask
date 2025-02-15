package ru.armetka.cft.testtask.service;

import ru.armetka.cft.testtask.config.Config;
import ru.armetka.cft.testtask.entity.Statistics;
import ru.armetka.cft.testtask.enums.StatisticsModesEnum;

public interface OutputService {
    public void outputStatistics(Statistics stat, StatisticsModesEnum mode);
    public void outputFiles(String path, String prefix, Boolean appendMode);
}
