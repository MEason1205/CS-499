import java.util.function.Supplier;

/**
 * Utility to measure the time taken by an operation.
 */
public class Benchmark {
    public static <T> T measure(String name, Supplier<T> action) {
        long start = System.nanoTime();
        T result = action.get();
        long duration = System.nanoTime() - start;
        System.out.printf("%-30s: %,d ns%n", name, duration);
        return result;
    }
}
