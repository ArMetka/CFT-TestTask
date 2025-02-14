package ru.armetka.cft.testtask;

import org.apache.commons.cli.ParseException;
import ru.armetka.cft.testtask.config.Config;

public class App {
    public static void main(String[] args) {

        Config cfg = new Config();
        try {
            cfg.loadFromArgs(args);
        } catch (ParseException e) {
            System.err.println("failed to parse args: " + e.getMessage());
            return;
        }

        System.out.println(cfg.getOutputPath());
        System.out.println(cfg.getOutputPrefix());
        System.out.println(cfg.getAppendMode());
        System.out.println(cfg.getStatisticsMode());
        System.out.println(cfg.getInputFiles());
    }
}