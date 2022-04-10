package functions.logarithm;

import functions.Function;

public class LogFunction extends Function {

    private Ln ln;
    private Log2 log2;
    private Log3 log3;
    private Log5 log5;
    private Log10 log10;

    public LogFunction(double precision) {
        ln = new Ln(precision);
        log2 = new Log2(precision);
        log3 = new Log3(precision);
        log5 = new Log5(precision);
        log10 = new Log10(precision);
    }

    @Override
    public Double calculate(double x) {
        return Math.pow(ln.calculate(x) * log2.calculate(x) * ln.calculate(x), 2) * log5.calculate(x) /
                (log5.calculate(x) - (log3.calculate(x) + log10.calculate(x) + ln.calculate(x)));
    }

    public void setLn(Ln ln) {
        this.ln = ln;
    }

    public void setLog2(Log2 log2) {
        this.log2 = log2;
    }

    public void setLog3(Log3 log3) {
        this.log3 = log3;
    }

    public void setLog5(Log5 log5) {
        this.log5 = log5;
    }

    public void setLog10(Log10 log10) {
        this.log10 = log10;
    }
}
