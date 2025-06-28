package myfilter;

public class ReportManager {
    public static void handleOutput(FileProcessor processor, Options options) {
        OutputWriter writer = new OutputWriter(options);
        writer.writeIntegers(processor.integers);
        writer.writeFloats(processor.floats);
        writer.writeStrings(processor.strings);

        if (options.fullStats) {
            StatsCollector.printFullStats(
                    processor.integers,
                    processor.floats,
                    processor.strings
            );
        } else {
            processor.printShortStats();
        }
    }
}
