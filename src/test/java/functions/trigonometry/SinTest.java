package functions.trigonometry;

import csv.CsvLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(value = PER_CLASS)
class SinTest {
    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.01;

    private Sin sin;

    @BeforeAll
    public void init() {
        sin = new Sin(ACCURACY);
    }


    @AfterAll
    public void trigonomInCSV() {
        sin = new Sin(ACCURACY);
        CsvLogger csvLogger = new CsvLogger("sinFunction.csv", -6, 6, 1);
        csvLogger.writer(sin);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/sin_test_data.csv")
    public void tableValuesTest(float x, float expected) {
        double actual = sin.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void negativeAccuracyTest() {
        sin = new Sin(-1);
        assertThrows(IllegalArgumentException.class, () -> sin.calculate(1));
    }

    @Test
    public void nanTest() {
        assertThrows(IllegalArgumentException.class,
                () -> sin.calculate(Double.NaN));
    }

    @Test
    public void positiveInfinityTest() {
        double expected = Double.NaN;
        double actual = sin.calculate(Double.POSITIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        double expected = Double.NaN;
        double actual = sin.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void zeroAndOneFactorialTest(int param) {
        assertEquals(1, Sin.factorial(param));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2",
            "6, 3",
            "720, 6"
    })
    void factorialTest(int answer,  int curr) {
        assertEquals(answer, Sin.factorial(curr));
    }

    @Test
    void factorialLessThanZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> Sin.factorial(-1));
    }
}