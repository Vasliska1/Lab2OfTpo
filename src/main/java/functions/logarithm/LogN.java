package functions.logarithm;


import functions.Function;

public class LogN extends Function {


    private Ln ln;
    private final int base;

    public LogN(double precision, int base) {
        ln = new Ln(precision);
        this.base = base;
    }
    public void setLn(Ln ln) {
        this.ln = ln;
    }
    @Override
    public Double calculate(double x) {
        return ln.calculate(x) / ln.calculate(this.base);
    }
}
