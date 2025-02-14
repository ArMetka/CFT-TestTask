package ru.armetka.cft.testtask.storage;

import java.util.List;

public interface ParsedDataStorage {
    public void insertIntoLongs(Long entry);

    public void insertIntoDoubles(Double entry);

    public void insertIntoStrings(String entry);

    public List<Long> getLongList();

    public List<Double> getDoubleList();

    public List<String> getStringList();
}
