package functions;

import csv.CsvLogger;
import functions.logarithm.LogFunction;
import functions.trigonometry.TrigonometryFunction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Mockito.when;

@TestInstance(value = PER_CLASS)
class SystemFunctionsTest {

    private static final double DELTA = 0.000001;
    private static final double ACCURACY = 0.01;
    private static TrigonometryFunction trigonometryFunctionMock;
    private static LogFunction logFunctionMock;

    @BeforeAll
    public void setUp() {
        trigonometryFunctionMock = Mockito.mock(TrigonometryFunction.class);
        logFunctionMock = Mockito.mock(LogFunction.class);

        when(logFunctionMock.calculate(AdditionalMatchers.eq(0, 0.1))).thenReturn(NaN);
        when(logFunctionMock.calculate(AdditionalMatchers.eq(0.2, 0.1))).thenReturn(-13.0432);
        when(logFunctionMock.calculate(AdditionalMatchers.eq(0.8, 0.1))).thenReturn(-0.0048);
        when(logFunctionMock.calculate(AdditionalMatchers.eq(1.5, 0.1))).thenReturn(0.00000476);


        when(trigonometryFunctionMock.calculate(AdditionalMatchers.eq(-3.1415, 0.1))).thenReturn(0.0);
        when(trigonometryFunctionMock.calculate(AdditionalMatchers.eq(-0.7853982, 0.1))).thenReturn(-0.3364);
        when(trigonometryFunctionMock.calculate(AdditionalMatchers.eq(1.5707963, 0.1))).thenReturn(1.0);
        when(trigonometryFunctionMock.calculate(AdditionalMatchers.eq(2.3561945, 0.1))).thenReturn(0.3323);
    }

    @AfterAll
    public void logInCSV() {
        SystemFunctions systemFunctions = new SystemFunctions(new TrigonometryFunction(ACCURACY), new LogFunction(ACCURACY));
        CsvLogger csvLogger = new CsvLogger("system_test.csv", -5, 5, 0.1);
        csvLogger.writer(systemFunctions);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/functions_system_test_data.csv")
    public void systemTest(float x, float expected) {
        SystemFunctions systemFunctions = new SystemFunctions(trigonometryFunctionMock, logFunctionMock);
        double actual = systemFunctions.calculate(x);
        assertEquals(expected, actual, DELTA);
    }
}