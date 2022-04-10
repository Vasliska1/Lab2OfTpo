package functions.logarithm;

import csv.CsvLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(value = PER_CLASS)
class LogFunctionTest {
    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.01;

    private LogFunction logFunction;


    @AfterAll
    public void logInCSV() {
        logFunction = new LogFunction(ACCURACY);
        CsvLogger csvLogger = new CsvLogger("logFunction.csv", 0.1, 10, 0.2);
        csvLogger.writer(logFunction);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log_function_test_data.csv")
    public void tableValuesStubsTest(float x, float expected) {
        logFunction = new LogFunction(ACCURACY);
        logFunction.setLn(LogMocks.getLnMock());
        logFunction.setLog3(LogMocks.getLog3Mock());
        logFunction.setLog5(LogMocks.getLog5Mock());
        logFunction.setLog10(LogMocks.getLog10Mock());
        logFunction.setLog2(LogMocks.getLog2Mock());
        double actual = logFunction.calculate(x);
        assertEquals(expected, actual, DELTA);
    }
}