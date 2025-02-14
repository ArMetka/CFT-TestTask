package ru.armetka.cft.testtask.storage.impl;

import ru.armetka.cft.testtask.storage.ParsedDataStorage;

import java.util.ArrayList;
import java.util.List;

public class ParsedDataStorageImpl implements ParsedDataStorage {
    private final List<Long> longList = new ArrayList<>();
    private final List<Double> doubleList = new ArrayList<>();
    private final List<String> stringList = new ArrayList<>();

    public ParsedDataStorageImpl() {
    }

    @Override
    public void insertIntoLongs(Long entry) {
        this.longList.add(entry);
    }

    @Override
    public void insertIntoDoubles(Double entry) {
        this.doubleList.add(entry);
    }

    @Override
    public void insertIntoStrings(String entry) {
        this.stringList.add(entry);
    }

    public List<Long> getLongList() {
        return longList;
    }

    public List<Double> getDoubleList() {
        return doubleList;
    }

    public List<String> getStringList() {
        return stringList;
    }
}
