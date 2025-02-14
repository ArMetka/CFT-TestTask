package ru.armetka.cft.testtask;

import ru.armetka.cft.testtask.config.Config;
import ru.armetka.cft.testtask.service.ParseService;
import ru.armetka.cft.testtask.service.impl.ParseServiceImpl;
import ru.armetka.cft.testtask.storage.ParsedDataStorage;
import ru.armetka.cft.testtask.storage.impl.ParsedDataStorageImpl;

public class App {
    private final Config cfg;
    private final ParsedDataStorage parsedDataStorage;
    private final ParseService parseService;

    public App(Config cfg) {
        this.cfg = cfg;
        this.parsedDataStorage = new ParsedDataStorageImpl();
        this.parseService = new ParseServiceImpl(this.parsedDataStorage);
    }

    public void run() {
        for (var file : this.cfg.getInputFiles()) {
            this.parseService.processFile(file);
        }

        // TODO: delete debug
        parsedDataStorage.print();


    }
}
