import java.io.*;

public class SpacesToDashes{
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            reader.lines()
                    .map(line -> line.replace(" ", "-"))
                    .forEach(line -> {
                        try {
                            writer.write(line);
                            writer.newLine();
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });

            System.out.println("W pliku spacje zostaly zastapione myslnikami.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}
