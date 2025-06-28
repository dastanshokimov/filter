package myfilter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
    private final Options options;

    public List<String> integers = new ArrayList<>();
    public List<String> floats = new ArrayList<>();
    public List<String> strings = new ArrayList<>();

    public FileProcessor(Options options) {
        this.options = options;
    }

    public void process() {
        for (String inputFile : options.inputFiles) {
            Path filePath = Path.of(inputFile);

            try {
                List<String> lines = Files.readAllLines(filePath);
                for (String line : lines) {
                    DataType type = TypeDetector.detectType(line);
                    switch (type) {
                        case INTEGER -> integers.add(line);
                        case FLOAT -> floats.add(line);
                        case STRING -> strings.add(line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Ошибка чтения файла: " + inputFile + " - " + e.getMessage());
            }
        }
    }

    public void printShortStats() {
        System.out.println("Integers: " + integers.size());
        System.out.println("Floats: " + floats.size());
        System.out.println("Strings: " + strings.size());
    }
}
