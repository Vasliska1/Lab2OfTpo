package functions.trigonometry;

import csv.CsvLogger;
import functions.logarithm.LogFunction;
import functions.logarithm.LogMocks;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(value = PER_CLASS)
class TrigonometryFunctionTest {
    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.01;

    private TrigonometryFunction trigonometryFunction;


    @AfterAll
    public void trigonomInCSV() {
        trigonometryFunction = new TrigonometryFunction(ACCURACY);
        CsvLogger csvLogger = new CsvLogger("trigoFunction.csv", -7, 6, 0.5);
        csvLogger.writer(trigonometryFunction);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry_function_test_data.csv")
    public void tableValuesStubsTest(float x, float expected) {
        trigonometryFunction = new TrigonometryFunction(ACCURACY);
       trigonometryFunction.setSin(TrigonometryMocks.getSinMock());
        double actual = trigonometryFunction.calculate(x);
        assertEquals(expected, actual, DELTA);
    }
}