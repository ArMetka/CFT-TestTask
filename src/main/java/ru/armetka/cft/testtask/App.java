package ru.armetka.cft.testtask;

import ru.armetka.cft.testtask.config.Config;
import ru.armetka.cft.testtask.enums.StatisticsModesEnum;
import ru.armetka.cft.testtask.service.OutputService;
import ru.armetka.cft.testtask.service.ParseService;
import ru.armetka.cft.testtask.service.StatisticsService;
import ru.armetka.cft.testtask.service.impl.OutputServiceImpl;
import ru.armetka.cft.testtask.service.impl.ParseServiceImpl;
import ru.armetka.cft.testtask.service.impl.StatisticsServiceImpl;
import ru.armetka.cft.testtask.storage.ParsedDataStorage;
import ru.armetka.cft.testtask.storage.impl.ParsedDataStorageImpl;

public class App {
    private final Config cfg;
    private final ParsedDataStorage parsedDataStorage;
    private final ParseService parseService;
    private final StatisticsService statisticsService;
    private final OutputService outputService;

    public App(Config cfg) {
        this.cfg = cfg;
        this.parsedDataStorage = new ParsedDataStorageImpl();
        this.parseService = new ParseServiceImpl(this.parsedDataStorage);
        this.statisticsService = new StatisticsServiceImpl(this.parsedDataStorage);
        this.outputService = new OutputServiceImpl(this.parsedDataStorage);
    }

    public void run() {
        for (var file : this.cfg.getInputFiles()) {
            this.parseService.processFile(file);
        }

        var stat = this.statisticsService.generateStatistics(cfg.getStatisticsMode());

        this.outputService.outputStatistics(stat, cfg.getStatisticsMode());
        this.outputService.outputFiles(cfg.getOutputPath(), cfg.getOutputPrefix(), cfg.getAppendMode());
    }
}
