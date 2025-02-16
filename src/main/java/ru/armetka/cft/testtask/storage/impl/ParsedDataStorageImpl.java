package ru.armetka.cft.testtask.storage.impl;

import ru.armetka.cft.testtask.storage.ParsedDataStorage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ParsedDataStorageImpl implements ParsedDataStorage {
    private final List<BigInteger> intList = new ArrayList<>();
    private final List<BigDecimal> floatList = new ArrayList<>();
    private final List<String> stringList = new ArrayList<>();

    public ParsedDataStorageImpl() {
    }

    @Override
    public void insertIntoInts(BigInteger entry) {
        this.intList.add(entry);
    }

    @Override
    public void insertIntoFloats(BigDecimal entry) {
        this.floatList.add(entry);
    }

    @Override
    public void insertIntoStrings(String entry) {
        this.stringList.add(entry);
    }

    public List<BigInteger> getIntList() {
        return intList;
    }

    public List<BigDecimal> getFloatList() {
        return floatList;
    }

    public List<String> getStringList() {
        return stringList;
    }
}
