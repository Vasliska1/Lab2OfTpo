package csv;

import functions.Function;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvLogger {
    private final double step;
    private final double start;
    private final double end;
    private final char CSV_SEPARATOR = ' ';
    private String filePath = "src/test/resources/output/";

    public CsvLogger(String fileName, double start, double end, double step) {
        this.filePath = filePath + fileName;
        this.start = start;
        this.end = end;
        this.step = step;
    }

    public void writer(Function function) {
        String csvString = "";

        try {
            Files.deleteIfExists(Paths.get(this.filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintStream printStream = new PrintStream(new FileOutputStream(filePath, true))) {
            for (double i = start; i < end; i += step) {
                double result = function.calculate(i);
                csvString = String.format("%f%s %f\n", i, CSV_SEPARATOR, result);
                printStream.print(csvString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
