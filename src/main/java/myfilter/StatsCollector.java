package myfilter;

import java.util.List;

public class StatsCollector {
    public static void printFullStats(List<String> integers, List<String> floats, List<String> strings) {
        printIntStats(integers);
        printFloatStats(floats);
        printStringStats(strings);
    }

    private static void printIntStats(List<String> integers) {
        if (integers.isEmpty()) return;

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long sum = 0;
        long count = 0;

        for (String s : integers) {
            try {
                long val = Long.parseLong(s);
                min = Math.min(min, val);
                max = Math.max(max, val);
                sum += val;
                count++;
            } catch (NumberFormatException e) {
                System.err.println("Некорректное целое число: " + s);
            }
        }

        if (count > 0) {
            double avg = (double) sum / count;
            System.out.println("\n[Integers]");
            System.out.printf("Count: %d\n", count);
            System.out.printf("Min: %d\n", min);
            System.out.printf("Max: %d\n", max);
            System.out.printf("Sum: %d\n", sum);
            System.out.printf("Average: %.4f\n", avg);
        }
    }

    private static void printFloatStats(List<String> floats) {
        if (floats.isEmpty()) return;

        double min = Double.MAX_VALUE;
        double max = -Double.MAX_VALUE;
        double sum = 0;
        double count = 0;

        for (String s : floats) {
            try {
                double val = Double.parseDouble(s);
                min = Math.min(min, val);
                max = Math.max(max, val);
                sum += val;
                count++;
            } catch (NumberFormatException e) {
                System.err.println("Некорректное вещественное число: " + s);
            }
        }

        double avg = sum / floats.size();

        System.out.println("\n[Floats]");
        System.out.println("Count: " + floats.size());
        System.out.printf("Min: %.4f\n", min);
        System.out.printf("Max: %.4f\n", max);
        System.out.printf("Sum: %.4f\n", sum);
        System.out.printf("Average: %.4f\n", avg);
    }

    private static void printStringStats(List<String> strings) {
        if (strings.isEmpty()) return;

        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;

        for (String s : strings) {
            int len = s.length();
            minLen = Math.min(minLen, len);
            maxLen = Math.max(maxLen, len);
        }

        System.out.println("\n[Strings]");
        System.out.println("Count: " + strings.size());
        System.out.println("Shortest length: " + minLen);
        System.out.println("Longest length: " + maxLen);
    }
}
