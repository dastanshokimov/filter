package filtertest;

import myfilter.Options;
import myfilter.OptionsValidator;
import myfilter.exception.HelpPrintedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsValidatorTest {
    @Test
    void defaultToShortStatsIfNothingSet() {
        Options options = new Options();
        options.inputFiles.add("in1.txt");
        OptionsValidator.validate(options);
        assertTrue(options.shortStats);
        assertFalse(options.fullStats);
        System.out.println("Тест #1: по умолчанию короткая статистика");
    }

    @Test
    void errorOnBothShortAndFull() {
        Options options = new Options();
        options.shortStats = true;
        options.fullStats = true;
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            OptionsValidator.validate(options);
        });
        assertTrue(ex.getMessage().contains("нельзя использовать"));
        System.out.println("Тест #2: при одновременном -s и -f получаем ошибку");
    }

    @Test
    void handlesHelpCorrectly() {
        Options options = new Options();
        options.inputFiles.add("--help");
        assertThrows(HelpPrintedException.class, () -> OptionsValidator.validate(options));
        System.out.println("Тест #3: при --help получаем опции и пример");
    }
}
