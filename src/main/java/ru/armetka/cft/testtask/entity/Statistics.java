package ru.armetka.cft.testtask.entity;

public class Statistics {
    // Short
    private int longsCount;
    private int doublesCount;
    private int stringsCount;

    // Full
    private long longsMin;
    private long longsMax;
    private long longsSum;
    private long longsAvg;

    private double doublesMin;
    private double doublesMax;
    private double doublesSum;
    private double doublesAvg;

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

    public long getLongsSum() {
        return longsSum;
    }

    public void setLongsSum(long longsSum) {
        this.longsSum = longsSum;
    }

    public long getLongsAvg() {
        return longsAvg;
    }

    public void setLongsAvg(long longsAvg) {
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

    public double getDoublesSum() {
        return doublesSum;
    }

    public void setDoublesSum(double doublesSum) {
        this.doublesSum = doublesSum;
    }

    public double getDoublesAvg() {
        return doublesAvg;
    }

    public void setDoublesAvg(double doublesAvg) {
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
