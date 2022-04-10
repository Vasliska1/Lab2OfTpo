package functions.logarithm;

import csv.CsvLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.AdditionalMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Log3Test {
    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private Log3 log3;
    private Ln ln;
    @BeforeEach
    public void setUp() {
        ln = mock(Ln.class);
        when(ln.calculate(0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(ln.calculate(Double.NaN)).thenReturn(Double.NaN);
        when(ln.calculate(AdditionalMatchers.eq(0.2, 0.1))).thenReturn(-1.609437912);
        when(ln.calculate(AdditionalMatchers.eq(1.0, 0.1))).thenReturn(0.0);
        when(ln.calculate(AdditionalMatchers.eq(2.0, 0.1))).thenReturn(0.6931472);
        when(ln.calculate(AdditionalMatchers.eq(3.0, 0.1))).thenReturn(1.0986122);
        when(ln.calculate(AdditionalMatchers.eq(4.0, 0.1))).thenReturn(1.3862944);
        when(ln.calculate(AdditionalMatchers.eq(5.0, 0.1))).thenReturn(1.6094379);
        when(ln.calculate(AdditionalMatchers.eq(6.0, 0.1))).thenReturn(1.7917595);
        when(ln.calculate(AdditionalMatchers.eq(7.0, 0.1))).thenReturn(1.9459101);
        when(ln.calculate(AdditionalMatchers.eq(8.0, 0.1))).thenReturn(2.0794415);
        when(ln.calculate(AdditionalMatchers.eq(9.0, 0.1))).thenReturn(2.1972246);
        when(ln.calculate(AdditionalMatchers.eq(10.0, 0.1))).thenReturn(2.3025851);
    }

    @AfterAll
    public void logInCSV() {
        log3 = new Log3(ACCURACY);
        CsvLogger csvLogger = new CsvLogger("log3.csv", 1, 2, 0.1);
        csvLogger.writer(log3);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log3_test_data.csv")
    public void tableValuesStubsTest(float x, float expected) {
        log3 = new Log3(ACCURACY);
        log3.setLn(ln);
        double actual = log3.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanStubsTest() {
        log3 = new Log3(ACCURACY);
        log3.setLn(ln);
        double actual = log3.calculate(Double.NaN);
        assertEquals(Double.NaN, actual, DELTA);
    }

    @Test
    public void positiveInfinityStubsTest() {
        log3 = new Log3(ACCURACY);
        log3.setLn(ln);
        double actual = log3.calculate(Double.NaN);
        assertEquals(Double.NaN, actual, DELTA);
    }
}