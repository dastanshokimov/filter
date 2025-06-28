package myfilter;

import myfilter.exception.HelpPrintedException;

public class Main {
    public static void main(String[] args) {
        Options options = Options.parseArgs(args);

        try {
            OptionsValidator.validate(options);
        } catch (HelpPrintedException e) {
            return; // тихо завершаем
        }

        FileProcessor processor = new FileProcessor(options);
        processor.process();

        ReportManager.handleOutput(processor, options);
    }
}