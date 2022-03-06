package math;

public class MathCalculate {

    public static double sin(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x))
            return Double.NaN;
        double result = 0;
        for (int n = 1; n < 7; n++) {
            result += Math.pow(-1, n - 1) * Math.pow(x, 2 * n - 1) / factorial(2 * n - 1);
        }
        return result;
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
}
