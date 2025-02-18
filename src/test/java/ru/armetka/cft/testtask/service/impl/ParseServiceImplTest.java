package ru.armetka.cft.testtask.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.armetka.cft.testtask.service.ParseService;
import ru.armetka.cft.testtask.storage.ParsedDataStorage;
import ru.armetka.cft.testtask.storage.impl.ParsedDataStorageImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class ParseServiceImplTest {
    private ParsedDataStorage storageMock;
    private ParseService parseService;
    private Method parseLine;

    private final List<BigInteger> intList = new ArrayList<>();
    private final List<BigDecimal> floatList = new ArrayList<>();
    private final List<String> stringList = new ArrayList<>();

    @BeforeEach
    public void setup() throws NoSuchMethodException {
        this.storageMock = Mockito.mock(ParsedDataStorageImpl.class);
        this.parseService = new ParseServiceImpl(this.storageMock);

        this.parseLine = this.parseService.getClass().getDeclaredMethod("parseLine", String.class);
        this.parseLine.setAccessible(true);

        Mockito.when(this.storageMock.getIntList()).thenReturn(this.intList);
        Mockito.when(this.storageMock.getFloatList()).thenReturn(this.floatList);
        Mockito.when(this.storageMock.getStringList()).thenReturn(this.stringList);
    }

    @Test
    public void itHandlesEmptyStrings() throws InvocationTargetException, IllegalAccessException {
        List<String> testStrings = new ArrayList<>();

        testStrings.add("");
        testStrings.add("test");
        testStrings.add("");

        for (var str : testStrings) {
            this.parseLine.invoke(this.parseService, str);
        }

        Mockito.verify(this.storageMock, Mockito.times(1)).insertIntoStrings(Mockito.eq("test"));
    }

    @Test
    public void itParsesMixedData() throws InvocationTargetException, IllegalAccessException {
        List<String> testData = new ArrayList<>();

        testData.add("1234567890123456789012345678901234567890");
        testData.add("1.528535047E-25");
        testData.add("zero");

        for (var str : testData) {
            this.parseLine.invoke(this.parseService, str);
        }

        Mockito.verify(this.storageMock, Mockito.times(1))
                .insertIntoInts(new BigInteger("1234567890123456789012345678901234567890"));
        Mockito.verify(this.storageMock, Mockito.times(1))
                .insertIntoFloats(new BigDecimal("1.528535047E-25"));
        Mockito.verify(this.storageMock, Mockito.times(1))
                .insertIntoStrings("zero");
    }
}