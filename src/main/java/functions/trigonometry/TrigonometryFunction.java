package functions.trigonometry;

import functions.Function;

public class TrigonometryFunction extends Function {

    private Sin sin;

    public void setSin(Sin sin) {
        this.sin = sin;
    }

    public TrigonometryFunction(double precision) {
        sin = new Sin(precision);
    }

    @Override
    public Double calculate(double x) {
        return Math.pow(sin.calculate(x), 3);
    }
}
