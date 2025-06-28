package myfilter;

public class TypeDetector {
    public static DataType detectType(String line) {
        if (line == null || line.isBlank()) {
            return DataType.STRING;
        }

        try {
            Long.parseLong(line);
            return DataType.INTEGER;
        } catch (NumberFormatException ignored) {}

        try {
            Double.parseDouble(line);
            return DataType.FLOAT;
        } catch (NumberFormatException ignored) {}

        return DataType.STRING;
    }
}
