package functions;

import functions.logarithm.LogFunction;
import functions.trigonometry.TrigonometryFunction;

public class SystemFunctions extends Function{

    private final TrigonometryFunction trigonometryFunction;
    private final LogFunction logFunction;

    public SystemFunctions(TrigonometryFunction trigonometryFunction, LogFunction logFunction) {
        this.trigonometryFunction = trigonometryFunction;
        this.logFunction = logFunction;
    }

    @Override
    public Double calculate(double x) {
        if (x <= 0) {
            return trigonometryFunction.calculate(x);
        } else {
            return this.logFunction.calculate(x);
        }
    }
}
