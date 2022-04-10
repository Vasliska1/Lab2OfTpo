package functions.logarithm;

import csv.CsvLogger;
import functions.trigonometry.Sin;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LnTest {
    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private Ln ln;

    @BeforeEach
    public void setUp() {
        ln = new Ln(ACCURACY);
    }
    @AfterAll
    public void logInCSV() {
        CsvLogger csvLogger = new CsvLogger("ln.csv", 0.5, 6, 0.5);
        csvLogger.writer(ln);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/ln_test_data.csv")
    public void tableValuesTest(float x, float expected) {
        assertEquals(expected, ln.calculate(x), DELTA);
    }

    @Test
    public void NaNTest() {
        double actual = ln.calculate(Double.NaN);
        assertEquals(Double.NaN, actual, DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        double actual = ln.calculate(Double.NaN);
        assertEquals(Double.NaN, actual, DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        double actual = ln.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(Double.NaN, actual, DELTA);
    }
}