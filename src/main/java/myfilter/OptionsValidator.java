package myfilter;

import myfilter.exception.HelpPrintedException;

public class OptionsValidator {
    public static void validate(Options options) {
        if (options.inputFiles.contains("--help")) {
            printHelp();
            throw new HelpPrintedException();
        }

        if (options.shortStats && options.fullStats) {
            throw new IllegalStateException("Ошибка: нельзя использовать -s и -f одновременно.");
        }

        if (!options.shortStats && !options.fullStats) {
            options.shortStats = true;
        }
    }

    private static void printHelp() {
        System.out.println("""
            Утилита фильтрации содержимого файлов.

            Опции:
              -s          краткая статистика (по умолчанию, если не указано -f)
              -f          полная статистика (min, max, sum, avg)
              -a          дописывать в файлы (append)
              -p <prefix> задать префикс для файлов
              -o <path>   задать папку для вывода файлов
              --help      вывести эту справку

            Пример запуска:
              java -jar utilfilter.jar -f -p result_ -o out/ in1.txt in2.txt
            """);
    }
}
