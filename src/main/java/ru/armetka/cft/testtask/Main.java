package ru.armetka.cft.testtask;

import org.apache.commons.cli.ParseException;
import ru.armetka.cft.testtask.config.Config;

public class Main {
    public static void main(String[] args) {

        Config cfg = new Config();
        try {
            cfg.loadFromArgs(args);
        } catch (ParseException e) {
            System.err.println("failed to parse args: " + e.getMessage());
            System.exit(1);
        }

        App app = new App(cfg);
        app.run();

    }
}