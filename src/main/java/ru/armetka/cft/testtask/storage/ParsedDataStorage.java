package ru.armetka.cft.testtask.storage;

public interface ParsedDataStorage {
    public void insertIntoLongs(Long entry);

    public void insertIntoDoubles(Double entry);

    public void insertIntoStrings(String entry);

    // TODO: delete debug
    public void print();
}
