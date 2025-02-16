package ru.armetka.cft.testtask.storage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface ParsedDataStorage {
    public void insertIntoInts(BigInteger entry);

    public void insertIntoFloats(BigDecimal entry);

    public void insertIntoStrings(String entry);

    public List<BigInteger> getIntList();

    public List<BigDecimal> getFloatList();

    public List<String> getStringList();
}
