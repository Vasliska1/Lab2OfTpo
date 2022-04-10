package functions.logarithm;

import csv.CsvLogger;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Log10Test {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private Log10 log10;
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
        log10 = new Log10(ACCURACY);
        CsvLogger csvLogger = new CsvLogger("log10.csv", 1, 2, 0.1);
        csvLogger.writer(log10);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/log10_test_data.csv")
    public void tableValuesStubsTest(float x, float expected) {
        log10 = new Log10(ACCURACY);
        log10.setLn(ln);
        double actual = log10.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanStubsTest() {
        log10 = new Log10(ACCURACY);
        log10.setLn(ln);
        double actual = log10.calculate(Double.NaN);
        assertEquals(Double.NaN, actual, DELTA);
    }

    @Test
    public void positiveInfinityStubsTest() {
        log10 = new Log10(ACCURACY);
        log10.setLn(ln);
        double actual = log10.calculate(Double.NaN);
        assertEquals(Double.NaN, actual, DELTA);
    }
}