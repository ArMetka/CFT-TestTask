package ru.armetka.cft.testtask.service.impl;

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
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        this.floatList.add(new BigDecimal("0"));
        this.floatList.add(new BigDecimal("0"));

        this.stringList.add("0");
        this.stringList.add("0");
        this.stringList.add("0");

        Statistics stat = this.statisticsService.generateStatistics(StatisticsModesEnum.SHORT);

        assertEquals(1, stat.getIntCount());
        assertEquals(2, stat.getFloatCount());
        assertEquals(3, stat.getStringCount());
    }

    @Test
    public void itHandlesZeroCountShort() {
        Statistics stat = this.statisticsService.generateStatistics(StatisticsModesEnum.SHORT);

        assertEquals(0, stat.getIntCount());
        assertEquals(0, stat.getFloatCount());
        assertEquals(0, stat.getStringCount());
    }

    @Test
    public void itCountsFull() {
        this.intList.add(new BigInteger("0"));

        this.floatList.add(new BigDecimal("0"));
        this.floatList.add(new BigDecimal("0"));

        this.stringList.add("0");
        this.stringList.add("0");
        this.stringList.add("0");

        Statistics stat = this.statisticsService.generateStatistics(StatisticsModesEnum.FULL);

        assertEquals(1, stat.getIntCount());
        assertEquals(2, stat.getFloatCount());
        assertEquals(3, stat.getStringCount());
    }

    @Test
    public void itHandlesZeroCountFull() {
        Statistics stat = this.statisticsService.generateStatistics(StatisticsModesEnum.FULL);

        assertEquals(0, stat.getIntCount());
        assertEquals(new BigInteger("0"), stat.getIntMin());
        assertEquals(new BigInteger("0"), stat.getIntMax());
        assertEquals(new BigInteger("0"), stat.getIntSum());
        assertEquals(new BigDecimal("0"), stat.getIntAvg());

        assertEquals(0, stat.getFloatCount());
        assertEquals(new BigDecimal("0"), stat.getFloatMin());
        assertEquals(new BigDecimal("0"), stat.getFloatMax());
        assertEquals(new BigDecimal("0"), stat.getFloatSum());
        assertEquals(new BigDecimal("0"), stat.getFloatAvg());

        assertEquals(0, stat.getStringCount());
        assertEquals(0, stat.getStringLenMin());
        assertEquals(0, stat.getStringLenMax());
    }

    @Test
    public void itCalculatesFull() {
        this.intList.add(new BigInteger("1234567891234567891234567890"));
        this.intList.add(new BigInteger("-1234567891234567891234567890"));
        this.intList.add(new BigInteger("50"));

        this.floatList.add(new BigDecimal("1234567891234567891234567890"));
        this.floatList.add(new BigDecimal("-1234567891234567891234567890"));
        this.floatList.add(new BigDecimal("-50"));

        this.stringList.add("very long string с русскими буквами!!!");
        this.stringList.add("この世の不利益はすべて当人の能力不足。");

        Statistics stat = this.statisticsService.generateStatistics(StatisticsModesEnum.FULL);

        assertEquals(3, stat.getIntCount());
        assertEquals(new BigInteger("-1234567891234567891234567890"), stat.getIntMin());
        assertEquals(new BigInteger("1234567891234567891234567890"), stat.getIntMax());
        assertEquals(new BigInteger("50"), stat.getIntSum());
        assertEquals(new BigDecimal("50").divide(new BigDecimal("3"), 4, RoundingMode.HALF_UP), stat.getIntAvg());

        assertEquals(3, stat.getFloatCount());
        assertEquals(new BigDecimal("-1234567891234567891234567890"), stat.getFloatMin());
        assertEquals(new BigDecimal("1234567891234567891234567890"), stat.getFloatMax());
        assertEquals(new BigDecimal("-50").setScale(4, RoundingMode.HALF_UP), stat.getFloatSum());
        assertEquals(new BigDecimal("-50").divide(new BigDecimal("3"), 4, RoundingMode.HALF_UP), stat.getFloatAvg());

        assertEquals(2, stat.getStringCount());
        assertEquals(19, stat.getStringLenMin());
        assertEquals(38, stat.getStringLenMax());
    }
}