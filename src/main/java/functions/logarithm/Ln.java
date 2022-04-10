package functions.logarithm;

import functions.Function;

public class Ln extends Function {

    private double precision;

    public Ln(double precision) {
        this.precision = precision;
    }

    @Override
    public Double calculate(double x) {
        if (Double.isNaN(x) || x <= 0.0) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }

        if (x == 1.0) {
            return 0.0;
        }
        if (x > 2) {
            return calculate(x / 2.0) + calculate(2.0);
        }

        double fraction = this.precision + 1;
        double ln = 0;
        int n = 1;

        while (Math.abs(fraction) >= precision / 1000) {
            fraction = (Math.pow(-1, n + 1) / n) * Math.pow(x - 1, n);
            ln += fraction;
            n++;
        }
        return ln;
    }
}
