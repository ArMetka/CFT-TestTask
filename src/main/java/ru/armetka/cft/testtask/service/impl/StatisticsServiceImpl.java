package ru.armetka.cft.testtask.service.impl;

import ru.armetka.cft.testtask.entity.Statistics;
import ru.armetka.cft.testtask.enums.StatisticsModesEnum;
import ru.armetka.cft.testtask.service.StatisticsService;
import ru.armetka.cft.testtask.storage.ParsedDataStorage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class StatisticsServiceImpl implements StatisticsService {
    private final ParsedDataStorage storage;

    public StatisticsServiceImpl(ParsedDataStorage storage) {
        this.storage = storage;
    }

    @Override
    public Statistics generateStatistics(StatisticsModesEnum mode) {
        var stat = new Statistics();

        switch (mode) {
            case SHORT:
                setStatCount(stat);
                break;
            case FULL:
                setStatCount(stat);
                setStatLongs(stat);
                setStatDoubles(stat);
                setStatStrings(stat);
                break;
            default:
                throw new RuntimeException("generate statistics: mode not implemented: " + mode.toString());
        }

        return stat;
    }

    private void setStatCount(Statistics stat) {
        stat.setLongsCount(this.storage.getLongList().size());
        stat.setDoublesCount(this.storage.getDoubleList().size());
        stat.setStringsCount(this.storage.getStringList().size());
    }

    private void setStatLongs(Statistics stat) {
        if (this.storage.getLongList().isEmpty()) {
            stat.setLongsMin(0);
            stat.setLongsMax(0);
            stat.setLongsSum(new BigInteger("0"));
            stat.setLongsAvg(new BigDecimal("0"));
            return;
        }

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        BigInteger sum = new BigInteger("0");
        BigDecimal avg;

        for (var item : this.storage.getLongList()) {
            if (item < min) {
                min = item;
            }

            if (item > max) {
                max = item;
            }

            sum = sum.add(BigInteger.valueOf(item));
        }

        avg = new BigDecimal(sum).divide(BigDecimal.valueOf(this.storage.getLongList().size()), 4, RoundingMode.HALF_UP);

        stat.setLongsMin(min);
        stat.setLongsMax(max);
        stat.setLongsSum(sum);
        stat.setLongsAvg(avg);
    }

    private void setStatDoubles(Statistics stat) {
        if (this.storage.getDoubleList().isEmpty()) {
            stat.setDoublesMin(0);
            stat.setDoublesMax(0);
            stat.setDoublesSum(new BigDecimal("0"));
            stat.setDoublesAvg(new BigDecimal("0"));
            return;
        }

        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        BigDecimal sum = new BigDecimal("0").setScale(4, RoundingMode.HALF_UP);
        BigDecimal avg;

        for (var item : this.storage.getDoubleList()) {
            if (item < min) {
                min = item;
            }

            if (item > max) {
                max = item;
            }

            sum = sum.add(BigDecimal.valueOf(item)).setScale(4, RoundingMode.HALF_UP);
        }

        avg = sum.divide(BigDecimal.valueOf(this.storage.getDoubleList().size()), 4, RoundingMode.HALF_UP);

        stat.setDoublesMin(min);
        stat.setDoublesMax(max);
        stat.setDoublesSum(sum);
        stat.setDoublesAvg(avg);
    }

    private void setStatStrings(Statistics stat) {
        if (this.storage.getStringList().isEmpty()) {
            stat.setStringsLenMin(0);
            stat.setStringsLenMax(0);
            return;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (var item : this.storage.getStringList()) {
            if (item.length() < min) {
                min = item.length();
            }

            if (item.length() > max) {
                max = item.length();
            }
        }

        stat.setStringsLenMin(min);
        stat.setStringsLenMax(max);
    }
}
