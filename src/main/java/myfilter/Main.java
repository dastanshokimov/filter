package myfilter;

public class Main {
    public static void main(String[] args) {
        Options options = Options.parseArgs(args);

        OptionsValidator.validate(options);

        FileProcessor processor = new FileProcessor(options);
        processor.process();

        ReportManager.handleOutput(processor, options);
    }
}