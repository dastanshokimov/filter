package filtertest;

import myfilter.DataType;
import myfilter.TypeDetector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeDetectorTest {
    @Test
    void detectInteger() {
        assertEquals(DataType.INTEGER, TypeDetector.detectType("42"));
        assertEquals(DataType.INTEGER, TypeDetector.detectType("-1000"));
    }

    @Test
    void detectFloat() {
        assertEquals(DataType.FLOAT, TypeDetector.detectType("3.14"));
        assertEquals(DataType.FLOAT, TypeDetector.detectType("-2.71828"));
        assertEquals(DataType.FLOAT, TypeDetector.detectType("1.5e10"));
    }

    @Test
    void detectString() {
        assertEquals(DataType.STRING, TypeDetector.detectType("hello world"));
        assertEquals(DataType.STRING, TypeDetector.detectType(""));
        assertEquals(DataType.STRING, TypeDetector.detectType("42.42.42"));
    }
}
