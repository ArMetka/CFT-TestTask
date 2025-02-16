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
                setStatInts(stat);
                setStatFloats(stat);
                setStatStrings(stat);
                break;
            default:
                throw new RuntimeException("generate statistics: mode not implemented: " + mode.toString());
        }

        return stat;
    }

    private void setStatCount(Statistics stat) {
        stat.setIntCount(this.storage.getIntList().size());
        stat.setFloatCount(this.storage.getFloatList().size());
        stat.setStringCount(this.storage.getStringList().size());
    }

    private void setStatInts(Statistics stat) {
        if (this.storage.getIntList().isEmpty()) {
            stat.setIntMin(new BigInteger("0"));
            stat.setIntMax(new BigInteger("0"));
            stat.setIntSum(new BigInteger("0"));
            stat.setIntAvg(new BigDecimal("0"));
            return;
        }

        BigInteger max = this.storage.getIntList().getFirst();
        BigInteger min = this.storage.getIntList().getFirst();
        BigInteger sum = new BigInteger("0");
        BigDecimal avg;

        for (BigInteger item : this.storage.getIntList()) {
            if (item.compareTo(min) < 0) {
                min = item;
            }

            if (item.compareTo(max) > 0) {
                max = item;
            }

            sum = sum.add(item);
        }

        avg = new BigDecimal(sum).divide(BigDecimal.valueOf(this.storage.getIntList().size()), 4, RoundingMode.HALF_UP);

        stat.setIntMin(min);
        stat.setIntMax(max);
        stat.setIntSum(sum);
        stat.setIntAvg(avg);
    }

    private void setStatFloats(Statistics stat) {
        if (this.storage.getFloatList().isEmpty()) {
            stat.setFloatMin(new BigDecimal("0"));
            stat.setFloatMax(new BigDecimal("0"));
            stat.setFloatSum(new BigDecimal("0"));
            stat.setFloatAvg(new BigDecimal("0"));
            return;
        }

        BigDecimal max = this.storage.getFloatList().getFirst();
        BigDecimal min = this.storage.getFloatList().getFirst();
        BigDecimal sum = new BigDecimal("0").setScale(4, RoundingMode.HALF_UP);
        BigDecimal avg;

        for (BigDecimal item : this.storage.getFloatList()) {
            if (item.compareTo(min) < 0) {
                min = item;
            }

            if (item.compareTo(max) > 0) {
                max = item;
            }

            sum = sum.add(item).setScale(4, RoundingMode.HALF_UP);
        }

        avg = sum.divide(BigDecimal.valueOf(this.storage.getFloatList().size()), 4, RoundingMode.HALF_UP);

        stat.setFloatMin(min);
        stat.setFloatMax(max);
        stat.setFloatSum(sum);
        stat.setFloatAvg(avg);
    }

    private void setStatStrings(Statistics stat) {
        if (this.storage.getStringList().isEmpty()) {
            stat.setStringLenMin(0);
            stat.setStringLenMax(0);
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

        stat.setStringLenMin(min);
        stat.setStringLenMax(max);
    }
}
