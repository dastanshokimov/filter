package myfilter;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Options {
    public boolean append = false;
    public boolean shortStats = false;
    public boolean fullStats = false;
    public String prefix = "";
    public Path outputPath = Path.of(".");
    public List<String> inputFiles = new ArrayList<>();

    public static Options parseArgs(String[] args) {
        Options options = new Options();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-a" -> options.append = true;
                case "-s" -> options.shortStats = true;
                case "-f" -> options.fullStats = true;
                case "-p" -> {
                    if (i + 1 < args.length) {
                        options.prefix = args[++i];
                    } else {
                        System.err.println("Error: -p requires a value");
                    }
                }
                case "-o" -> {
                    if (i + 1 < args.length) {
                        options.outputPath = Path.of(args[++i]);
                    } else {
                        System.err.println("Error: -o requires a path");
                    }
                }
                default -> options.inputFiles.add(args[i]);
            }
        }
        return options;
    }
}
