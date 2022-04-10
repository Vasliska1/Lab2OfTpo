package functions;

public abstract class Function {

    public static final int MAX_ITERATIONS = 1000000;
    public static final double DELTA = 1e-4;
    public abstract Double calculate(double x);
}
