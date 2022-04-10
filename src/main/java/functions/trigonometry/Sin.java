package functions.trigonometry;

import functions.Function;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Sin extends Function {
    private final double precision;

    public Sin(double precision) {
        this.precision = precision;
    }

    private double shortenRange(double x) {
        if (x > PI || x < -PI) {
            double k = x % (2 * PI);
            if (k < -PI) {
                return k + 2 * PI;
            }
            if (k > PI) {
                return k - 2 * PI;
            }
            return k;
        } else {
            return x;
        }
    }

    private double sinTailor(double val, int n) {
        return pow(-1, n) * pow(val, 2 * n + 1) / factorial(2 * n + 1);
    }

    public static int factorial(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Agrument should be more then 0");
        }
        if (n == 0) {
            return 1;
        }
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    @Override
    public Double calculate(double x) {
        x = shortenRange(x);
        if (this.precision <= 0)
            throw new IllegalArgumentException("Eps should be more then 0");
        double result = 0d;
        double current = 10d;
        double prev = 0d;
        int n = 0;
        while (Math.abs(prev - current) >= this.precision) {
            prev = current;
            current = sinTailor(x, n);
            result += current;
            n++;
        }
        return result;
    }
}
