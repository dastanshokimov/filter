package myfilter;

public class OptionsValidator {
    public static void validate(Options options) {
        if (options.inputFiles.contains("--help")) {
            printHelp();
            System.exit(0);
        }

        if (options.shortStats && options.fullStats) {
            System.err.println("Ошибка: нельзя использовать -s и -f одновременно. Выберите только одну статистику.");
            System.exit(1);
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
