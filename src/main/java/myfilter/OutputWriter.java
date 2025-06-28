package myfilter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class OutputWriter {
    private final Options options;

    public OutputWriter(Options options) {
        this.options = options;
    }

    private Path buildFilePath(String suffix) {
        String fileName = options.prefix + suffix + ".txt";
        return options.outputPath.resolve(fileName);
    }

    public void writeIntegers(List<String> integers) {
        if (!integers.isEmpty()) {
            writeToFile(buildFilePath("integers"), integers);
        }
    }

    public void writeFloats(List<String> floats) {
        if (!floats.isEmpty()) {
            writeToFile(buildFilePath("floats"), floats);
        }
    }

    public void writeStrings(List<String> strings) {
        if (!strings.isEmpty()) {
            writeToFile(buildFilePath("strings"), strings);
        }
    }

    private void writeToFile(Path path, List<String> lines) {
        try {
            if (options.append && Files.exists(path)) {
                Files.write(path, lines, StandardOpenOption.APPEND);
            } else {
                Files.write(path, lines);
            }
            System.out.println("Записан файл: " + path);
        } catch (IOException e) {
            System.err.println("Ошибка записи файла: " + path + " - " + e.getMessage());
        }
    }
}
