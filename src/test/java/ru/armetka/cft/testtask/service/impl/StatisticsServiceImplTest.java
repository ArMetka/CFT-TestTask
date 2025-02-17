package ru.armetka.cft.testtask.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.armetka.cft.testtask.entity.Statistics;
import ru.armetka.cft.testtask.enums.StatisticsModesEnum;
import ru.armetka.cft.testtask.service.StatisticsService;
import ru.armetka.cft.testtask.storage.ParsedDataStorage;
import ru.armetka.cft.testtask.storage.impl.ParsedDataStorageImpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class StatisticsServiceImplTest {
    private ParsedDataStorage storageMock;
    private StatisticsService statisticsService;

    private final List<BigInteger> intList = new ArrayList<>();
    private final List<BigDecimal> floatList = new ArrayList<>();
    private final List<String> stringList = new ArrayList<>();

    @BeforeEach
    public void setup() {
        this.storageMock = Mockito.mock(ParsedDataStorageImpl.class);
        this.statisticsService = new StatisticsServiceImpl(this.storageMock);

        Mockito.when(this.storageMock.getIntList()).thenReturn(this.intList);
        Mockito.when(this.storageMock.getFloatList()).thenReturn(this.floatList);
        Mockito.when(this.storageMock.getStringList()).thenReturn(this.stringList);
    }

    @Test
    public void itCountsShort() {
        this.intList.add(new BigInteger("0"));
        this.intList.add(new BigInteger("0"));

        this.floatList.add(new BigDecimal("0"));
        this.floatList.add(new BigDecimal("0"));
        this.floatList.add(new BigDecimal("0"));
        this.floatList.add(new BigDecimal("0"));

        this.stringList.add("0");
        this.stringList.add("0");
        this.stringList.add("0");

        Statistics stat = this.statisticsService.generateStatistics(StatisticsModesEnum.SHORT);

        Assertions.assertEquals(2, stat.getIntCount());
        Assertions.assertEquals(4, stat.getFloatCount());
        Assertions.assertEquals(3, stat.getStringCount());
    }

    @Test
    public void itHandlesZeroCount() {
        Statistics stat = this.statisticsService.generateStatistics(StatisticsModesEnum.SHORT);

        Assertions.assertEquals(0, stat.getIntCount());
        Assertions.assertEquals(0, stat.getFloatCount());
        Assertions.assertEquals(0, stat.getStringCount());
    }
}