import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer {
    private final Printer nextPrinter;

    public FilePrinter(Printer nextPrinter) {
        this.nextPrinter = nextPrinter;
    }
    @Override
    public void print(String str) {
        String filename = "printer_output.txt";
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(str + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (nextPrinter != null) {
            nextPrinter.print(str);
        }
    }
}