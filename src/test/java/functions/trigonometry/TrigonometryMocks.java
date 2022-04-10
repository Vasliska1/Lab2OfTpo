package functions.trigonometry;

import org.junit.jupiter.api.TestInstance;
import org.mockito.AdditionalMatchers;

import static java.lang.Double.NaN;
import static java.lang.Math.PI;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrigonometryMocks {
    public static Sin getSinMock() {
        Sin sin = mock(Sin.class);
        when(sin.calculate(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(0.0);
        when(sin.calculate(AdditionalMatchers.eq(0.5235988, 0.1))).thenReturn(0.5);
        when(sin.calculate(AdditionalMatchers.eq(0.7853982, 0.1))).thenReturn(0.7071);
        when(sin.calculate(AdditionalMatchers.eq(1.0471976, 0.1))).thenReturn(0.866);
        when(sin.calculate(AdditionalMatchers.eq(1.5707963, 0.1))).thenReturn(1.0);
        when(sin.calculate(AdditionalMatchers.eq(2.0943951, 0.1))).thenReturn(0.866);
        when(sin.calculate(AdditionalMatchers.eq(2.3561945, 0.1))).thenReturn(0.7071);
        when(sin.calculate(AdditionalMatchers.eq(3.1415927, 0.1))).thenReturn(-0.00000004641);
        when(sin.calculate(AdditionalMatchers.eq(4.1887902, 0.1))).thenReturn(-0.866);

        when(sin.calculate(AdditionalMatchers.eq(2 * PI + 0.5235988, 0.1))).thenReturn(0.5);
        when(sin.calculate(AdditionalMatchers.eq(2 * PI + 0.7853982, 0.1))).thenReturn(0.7071);
        when(sin.calculate(AdditionalMatchers.eq(2 * PI + 1.0471976, 0.1))).thenReturn(0.866);
        when(sin.calculate(AdditionalMatchers.eq(2 * PI + 1.5707963, 0.1))).thenReturn(1.0);
        when(sin.calculate(AdditionalMatchers.eq(2 * PI + 2.0943951, 0.1))).thenReturn(0.866);
        when(sin.calculate(AdditionalMatchers.eq(2 * PI + 2.3561945, 0.1))).thenReturn(0.7071);
        when(sin.calculate(AdditionalMatchers.eq(2 * PI + 3.1415927, 0.1))).thenReturn(0.0);
        when(sin.calculate(AdditionalMatchers.eq(2 * PI + 4.1887902, 0.1))).thenReturn(-0.866);

        when(sin.calculate(AdditionalMatchers.eq(-0.5235988, 0.1))).thenReturn(-0.5);
        when(sin.calculate(AdditionalMatchers.eq(-0.7853982, 0.1))).thenReturn(-0.7071);
        when(sin.calculate(AdditionalMatchers.eq(-1.0471976, 0.1))).thenReturn(-0.866);
        when(sin.calculate(AdditionalMatchers.eq(-1.5707963, 0.1))).thenReturn(-1.0);
        when(sin.calculate(AdditionalMatchers.eq(-2.0943951, 0.1))).thenReturn(-0.866);
        when(sin.calculate(AdditionalMatchers.eq(-2.3561945, 0.1))).thenReturn(-0.7071);
        when(sin.calculate(AdditionalMatchers.eq(-2.3561945, 0.1))).thenReturn(-0.7071);
        when(sin.calculate(AdditionalMatchers.eq(-3.1415927, 0.1))).thenReturn(0.0000000464);
        when(sin.calculate(AdditionalMatchers.eq(-4.1887902, 0.1))).thenReturn(0.866);
        when(sin.calculate(Double.POSITIVE_INFINITY)).thenReturn(NaN);
        when(sin.calculate(Double.NEGATIVE_INFINITY)).thenReturn(NaN);
        return sin;
    }
}
