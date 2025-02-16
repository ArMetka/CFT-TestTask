package ru.armetka.cft.testtask.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Statistics {
    // Short
    private int intCount;
    private int floatCount;
    private int stringCount;

    // Full
    private BigInteger intMin;
    private BigInteger intMax;
    private BigInteger intSum;
    private BigDecimal intAvg;

    private BigDecimal floatMin;
    private BigDecimal floatMax;
    private BigDecimal floatSum;
    private BigDecimal floatAvg;

    private int stringLenMin;
    private int stringLenMax;

    public Statistics() {
    }

    public int getIntCount() {
        return intCount;
    }

    public void setIntCount(int intCount) {
        this.intCount = intCount;
    }

    public int getFloatCount() {
        return floatCount;
    }

    public void setFloatCount(int floatCount) {
        this.floatCount = floatCount;
    }

    public int getStringCount() {
        return stringCount;
    }

    public void setStringCount(int stringCount) {
        this.stringCount = stringCount;
    }

    public BigInteger getIntMin() {
        return intMin;
    }

    public void setIntMin(BigInteger intMin) {
        this.intMin = intMin;
    }

    public BigInteger getIntMax() {
        return intMax;
    }

    public void setIntMax(BigInteger intMax) {
        this.intMax = intMax;
    }

    public BigInteger getIntSum() {
        return intSum;
    }

    public void setIntSum(BigInteger intSum) {
        this.intSum = intSum;
    }

    public BigDecimal getIntAvg() {
        return intAvg;
    }

    public void setIntAvg(BigDecimal intAvg) {
        this.intAvg = intAvg;
    }

    public BigDecimal getFloatMin() {
        return floatMin;
    }

    public void setFloatMin(BigDecimal floatMin) {
        this.floatMin = floatMin;
    }

    public BigDecimal getFloatMax() {
        return floatMax;
    }

    public void setFloatMax(BigDecimal floatMax) {
        this.floatMax = floatMax;
    }

    public BigDecimal getFloatSum() {
        return floatSum;
    }

    public void setFloatSum(BigDecimal floatSum) {
        this.floatSum = floatSum;
    }

    public BigDecimal getFloatAvg() {
        return floatAvg;
    }

    public void setFloatAvg(BigDecimal floatAvg) {
        this.floatAvg = floatAvg;
    }

    public int getStringLenMin() {
        return stringLenMin;
    }

    public void setStringLenMin(int stringLenMin) {
        this.stringLenMin = stringLenMin;
    }

    public int getStringLenMax() {
        return stringLenMax;
    }

    public void setStringLenMax(int stringLenMax) {
        this.stringLenMax = stringLenMax;
    }
}
