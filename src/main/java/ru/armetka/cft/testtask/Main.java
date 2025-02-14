package ru.armetka.cft.testtask;

import org.apache.commons.cli.*;
import ru.armetka.cft.testtask.config.Config;

public class Main {
    public static void main(String[] args) {

        Config cfg = new Config();
        try {
            cfg.loadFromArgs(args);
        } catch (ParseException e) {
            System.err.println("failed to parse args!");
        }

        System.out.println(cfg.getOutputPath());
        System.out.println(cfg.getOutputPrefix());
        System.out.println(cfg.getAppendMode());
        System.out.println(cfg.getStatisticsMode());
    }
}