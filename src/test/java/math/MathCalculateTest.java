package math;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathCalculateTest {
    final double EPS = 1.0e-4;

    @Test
    void zeroSinTest() {
        assertEquals(0, MathCalculate.sin(0));
    }

    @Test
    void NaNSinTest() {
        assertEquals(Double.NaN, MathCalculate.sin(Double.NaN));
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void InfSinTest(double param) {
        assertEquals(Double.NaN, MathCalculate.sin(param));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0.5, 6",
            "0.70710, 4",
            "0.86602, 3"
    })
    void firstQuartetSinTest(double answer, int degree) {
        assertEquals(answer, MathCalculate.sin(Math.PI / degree), EPS);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0.86602, 2, 3",
            "0.70710, 3, 4",
            "0.5, 5, 6"
    })
    void secondQuartetSinTest(double answer, int k, int degree) {
        assertEquals(answer, MathCalculate.sin(k * Math.PI / degree), EPS);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-0.5, 7, 6",
            "-0.70710, 5, 4",
            "-0.86602, 4, 3"
    })
    void thirdQuartetSinTest(double answer, int k, int degree) {
        assertEquals(answer, MathCalculate.sin(k * Math.PI / degree), 0.1);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-0.86602, -3",
            "-0.70710, -4",
            "-0.5, -6"
    })
    void forthQuartetSinTest(double answer, int degree) {
        assertEquals(answer, MathCalculate.sin(Math.PI / degree), 0.001);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void zeroAndOneFactorialTest(int param) {
        assertEquals(1, MathCalculate.factorial(param));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2",
            "6, 3",
            "720, 6"
    })
    void factorialTest(int answer,  int curr) {
        assertEquals(answer, MathCalculate.factorial(curr));
    }

    @Test
    void factorialLessThanZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> MathCalculate.factorial(-1));
    }
}
