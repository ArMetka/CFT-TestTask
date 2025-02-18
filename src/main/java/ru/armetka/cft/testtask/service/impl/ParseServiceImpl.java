package ru.armetka.cft.testtask.service.impl;

import ru.armetka.cft.testtask.service.ParseService;
import ru.armetka.cft.testtask.storage.ParsedDataStorage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ParseServiceImpl implements ParseService {
    private final ParsedDataStorage storage;

    public ParseServiceImpl(ParsedDataStorage storage) {
        this.storage = storage;
    }

    @Override
    public void processFile(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null) {
                this.parseLine(line);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("failed to open file for reading: " + e.getMessage() + ", skipping...");
            return;
        } catch (IOException e) {
            System.err.println("failed to read file: " + e.getMessage());
            System.exit(1);
        }
    }

    private void parseLine(String line) {
        if (Objects.equals(line, "")) {
            return;
        }

        try {
            BigInteger result = new BigInteger(line);
            this.storage.insertIntoInts(result);
            return;
        } catch (NumberFormatException ignored) {
        }

        try {
            BigDecimal result = new BigDecimal(line);
            this.storage.insertIntoFloats(result);
            return;
        } catch (NumberFormatException ignored) {
        }

        this.storage.insertIntoStrings(line);
    }
}
