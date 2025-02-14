package ru.armetka.cft.testtask.config;

import org.apache.commons.cli.*;
import ru.armetka.cft.testtask.enums.OptionsListEnum;
import ru.armetka.cft.testtask.enums.StatisticsModesEnum;

public class Config {
    private String outputPath;
    private String outputPrefix;
    private Boolean appendMode = false;
    private String statisticsMode = StatisticsModesEnum.SHORT.toString();
    private String[] inputFiles;

    public Config() {
    }

    public void loadFromArgs(String[] args) throws ParseException {
        Options opt = this.setupOptions();

        CommandLineParser parser = new DefaultParser(false);
        CommandLine cmd = parser.parse(opt, args);

        this.loadOptions(cmd);
    }

    private Options setupOptions() {
        Options opt = new Options();

        opt.addOption(OptionsListEnum.OUTPUT_PATH.toString(), true, "set output path");
        opt.addOption(OptionsListEnum.OUTPUT_PREFIX.toString(), true, "set prefix");
        opt.addOption(OptionsListEnum.APPEND_MODE.toString(), false, "set append mode");
        opt.addOption(OptionsListEnum.STATISTICS_SHORT.toString(), false, "short statistics output");
        opt.addOption(OptionsListEnum.STATISTICS_FULL.toString(), false, "full statistics output");

        return opt;
    }

    private void loadOptions(CommandLine cmd) {
        this.outputPath = cmd.getOptionValue(OptionsListEnum.OUTPUT_PATH.toString());
        if (this.outputPath == null) {
            this.outputPath = "."; // Current dir
        }

        this.outputPrefix = cmd.getOptionValue(OptionsListEnum.OUTPUT_PREFIX.toString());
        if (this.outputPrefix == null) {
            this.outputPrefix = ""; // No prefix
        }

        if (cmd.hasOption(OptionsListEnum.APPEND_MODE.toString())) {
            this.appendMode = true;
        }

        if (cmd.hasOption(OptionsListEnum.STATISTICS_SHORT.toString())) {
            this.statisticsMode = StatisticsModesEnum.SHORT.toString();
        }

        if (cmd.hasOption(OptionsListEnum.STATISTICS_FULL.toString())) {
            this.statisticsMode = StatisticsModesEnum.FULL.toString();
        }
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getOutputPrefix() {
        return outputPrefix;
    }

    public Boolean getAppendMode() {
        return appendMode;
    }

    public String getStatisticsMode() {
        return statisticsMode;
    }

    public String[] getInputFiles() {
        return inputFiles;
    }
}
