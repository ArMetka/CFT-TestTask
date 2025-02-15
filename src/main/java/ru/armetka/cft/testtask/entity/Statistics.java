package ru.armetka.cft.testtask.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Statistics {
    // Short
    private int longsCount;
    private int doublesCount;
    private int stringsCount;

    // Full
    private long longsMin;
    private long longsMax;
    private BigInteger longsSum;
    private BigDecimal longsAvg;

    private double doublesMin;
    private double doublesMax;
    private BigDecimal doublesSum;
    private BigDecimal doublesAvg;

    private int stringsLenMin;
    private int stringsLenMax;

    public Statistics() {
    }

    public int getLongsCount() {
        return longsCount;
    }

    public void setLongsCount(int longsCount) {
        this.longsCount = longsCount;
    }

    public int getDoublesCount() {
        return doublesCount;
    }

    public void setDoublesCount(int doublesCount) {
        this.doublesCount = doublesCount;
    }

    public int getStringsCount() {
        return stringsCount;
    }

    public void setStringsCount(int stringsCount) {
        this.stringsCount = stringsCount;
    }

    public long getLongsMin() {
        return longsMin;
    }

    public void setLongsMin(long longsMin) {
        this.longsMin = longsMin;
    }

    public long getLongsMax() {
        return longsMax;
    }

    public void setLongsMax(long longsMax) {
        this.longsMax = longsMax;
    }

    public BigInteger getLongsSum() {
        return longsSum;
    }

    public void setLongsSum(BigInteger longsSum) {
        this.longsSum = longsSum;
    }

    public BigDecimal getLongsAvg() {
        return longsAvg;
    }

    public void setLongsAvg(BigDecimal longsAvg) {
        this.longsAvg = longsAvg;
    }

    public double getDoublesMin() {
        return doublesMin;
    }

    public void setDoublesMin(double doublesMin) {
        this.doublesMin = doublesMin;
    }

    public double getDoublesMax() {
        return doublesMax;
    }

    public void setDoublesMax(double doublesMax) {
        this.doublesMax = doublesMax;
    }

    public BigDecimal getDoublesSum() {
        return doublesSum;
    }

    public void setDoublesSum(BigDecimal doublesSum) {
        this.doublesSum = doublesSum;
    }

    public BigDecimal getDoublesAvg() {
        return doublesAvg;
    }

    public void setDoublesAvg(BigDecimal doublesAvg) {
        this.doublesAvg = doublesAvg;
    }

    public int getStringsLenMin() {
        return stringsLenMin;
    }

    public void setStringsLenMin(int stringsLenMin) {
        this.stringsLenMin = stringsLenMin;
    }

    public int getStringsLenMax() {
        return stringsLenMax;
    }

    public void setStringsLenMax(int stringsLenMax) {
        this.stringsLenMax = stringsLenMax;
    }
}
