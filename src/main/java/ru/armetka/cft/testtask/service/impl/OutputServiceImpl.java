package ru.armetka.cft.testtask.service.impl;

import ru.armetka.cft.testtask.entity.Statistics;
import ru.armetka.cft.testtask.enums.StatisticsModesEnum;
import ru.armetka.cft.testtask.service.OutputService;
import ru.armetka.cft.testtask.storage.ParsedDataStorage;

public class OutputServiceImpl implements OutputService {
    private final ParsedDataStorage storage;

    public OutputServiceImpl(ParsedDataStorage storage) {
        this.storage = storage;
    }

    @Override
    public void outputStatistics(Statistics stat, StatisticsModesEnum mode) {
        StringBuilder sb = new StringBuilder(256);

        sb.append("\nFilter statistics. Mode = ");
        sb.append(mode.toString());
        sb.append("\n");

        switch (mode) {
            case SHORT:
                sb.append("Integer count = ").append(stat.getLongsCount()).append("\n");
                sb.append("Float count = ").append(stat.getDoublesCount()).append("\n");
                sb.append("String count = ").append(stat.getStringsCount()).append("\n");
                break;
            case FULL:
                sb.append("-----\nIntegers:\n");
                sb.append("Count = ").append(stat.getLongsCount()).append("\n");
                sb.append("Min = ").append(stat.getLongsMin()).append("\n");
                sb.append("Max = ").append(stat.getLongsMax()).append("\n");
                sb.append("Sum = ").append(stat.getLongsSum()).append("\n");
                sb.append("Avg = ").append(stat.getLongsAvg()).append("\n");
                sb.append("-----\nFloats:\n");
                sb.append("Count = ").append(stat.getDoublesCount()).append("\n");
                sb.append("Min = ").append(stat.getDoublesMin()).append("\n");
                sb.append("Max = ").append(stat.getDoublesMax()).append("\n");
                sb.append("Sum = ").append(stat.getDoublesSum()).append("\n");
                sb.append("Avg = ").append(stat.getDoublesAvg()).append("\n");
                sb.append("-----\nStrings:\n");
                sb.append("Count = ").append(stat.getStringsCount()).append("\n");
                sb.append("Min length = ").append(stat.getStringsLenMin()).append("\n");
                sb.append("Max length = ").append(stat.getStringsLenMax()).append("\n");
                break;
            default:
                throw new RuntimeException("output statistics: mode not implemented: " + mode.toString());
        }

        System.out.println(sb);
    }

    @Override
    public void outputFiles(String path, String prefix, Boolean appendMode) {

    }
}
