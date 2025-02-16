package ru.armetka.cft.testtask.service.impl;

import ru.armetka.cft.testtask.entity.Statistics;
import ru.armetka.cft.testtask.enums.StatisticsModesEnum;
import ru.armetka.cft.testtask.service.OutputService;
import ru.armetka.cft.testtask.storage.ParsedDataStorage;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OutputServiceImpl implements OutputService {
    private final ParsedDataStorage storage;

    public OutputServiceImpl(ParsedDataStorage storage) {
        this.storage = storage;
    }

    @Override
    public void outputStatistics(Statistics stat, StatisticsModesEnum mode) {
        StringBuilder sb = new StringBuilder(256);

        sb.append("\nFilter statistics. Mode = ");
        sb.append(mode.toString());
        sb.append("\n");

        switch (mode) {
            case SHORT:
                sb.append("Integer count = ").append(stat.getLongsCount()).append("\n");
                sb.append("Float count = ").append(stat.getDoublesCount()).append("\n");
                sb.append("String count = ").append(stat.getStringsCount()).append("\n");
                break;
            case FULL:
                sb.append("-----\nIntegers:\n");
                sb.append("Count = ").append(stat.getLongsCount()).append("\n");
                sb.append("Min = ").append(stat.getLongsMin()).append("\n");
                sb.append("Max = ").append(stat.getLongsMax()).append("\n");
                sb.append("Sum = ").append(stat.getLongsSum()).append("\n");
                sb.append("Avg = ").append(stat.getLongsAvg()).append("\n");
                sb.append("-----\nFloats:\n");
                sb.append("Count = ").append(stat.getDoublesCount()).append("\n");
                sb.append("Min = ").append(stat.getDoublesMin()).append("\n");
                sb.append("Max = ").append(stat.getDoublesMax()).append("\n");
                sb.append("Sum = ").append(stat.getDoublesSum()).append("\n");
                sb.append("Avg = ").append(stat.getDoublesAvg()).append("\n");
                sb.append("-----\nStrings:\n");
                sb.append("Count = ").append(stat.getStringsCount()).append("\n");
                sb.append("Min length = ").append(stat.getStringsLenMin()).append("\n");
                sb.append("Max length = ").append(stat.getStringsLenMax()).append("\n");
                break;
            default:
                throw new RuntimeException("output statistics: mode not implemented: " + mode.toString());
        }

        System.out.println(sb);
    }

    @Override
    public void outputFiles(String path, String prefix, Boolean appendMode) {
        try {
            Path integersPath = Paths.get(path, prefix + "integers.txt");
            Path floatsPath = Paths.get(path, prefix + "floats.txt");
            Path stringsPath = Paths.get(path, prefix + "strings.txt");

            this.writeList(integersPath, this.storage.getLongList(), appendMode);
            this.writeList(floatsPath, this.storage.getDoubleList(), appendMode);
            this.writeList(stringsPath, this.storage.getStringList(), appendMode);

        } catch (FileNotFoundException | InvalidPathException e) {
            System.err.println("failed to open file for writing: " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("failed to write file: " + e.getMessage());
            System.exit(1);
        }
    }

    private <T> void writeList(Path path, List<T> list, Boolean appendMode) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(
                path.toString(),
                StandardCharsets.UTF_8,
                appendMode)
        );

        for (var item : list) {
            writer.write(item.toString());
            writer.newLine();
        }

        writer.close();
    }
}
