package ru.armetka.cft.testtask.service.impl;

import ru.armetka.cft.testtask.service.ParseService;
import ru.armetka.cft.testtask.storage.ParsedDataStorage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
        try {
            var result = Long.parseLong(line);
            this.storage.insertIntoLongs(result);
            return;
        } catch (NumberFormatException ignored) {
        }

        try {
            var result = Double.parseDouble(line);
            this.storage.insertIntoDoubles(result);
            return;
        } catch (NumberFormatException ignored) {
        }

        this.storage.insertIntoStrings(line);
    }
}
