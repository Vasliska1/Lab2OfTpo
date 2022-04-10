import functions.Function;
import functions.logarithm.LogFunction;
import functions.trigonometry.Sin;
import functions.trigonometry.TrigonometryFunction;

public class Main {

    public static void main(String[] args) {

        LogFunction logFunction = new LogFunction(0.001);
        System.out.println(logFunction.calculate(0.1));
    }
}
