public class StringBuilderComparison {
    private static final int ITERATIONS = 50_000;

    static String withString() {
        String result = "";
        for (int i = 0; i < ITERATIONS; i++) {
            // TODO: result += "x";  (each update creates another String)
            result += "x";
        }
        return result;
    }

    static String withBuilder() {
        // Initial capacity avoids repeated buffer growth.
        String result = "";
        // TODO: StringBuilder result = new StringBuilder(ITERATIONS);
        for (int i = 0; i < ITERATIONS; i++) {
            // TODO: result.append('x');
            result.append('x');
        }
        // TODO: return result.toString();
        return result.toString();
    }

    public static void main(String[] args) {
        // TODO: time withString() with System.nanoTime()
        // TODO: time withBuilder() with System.nanoTime()
        // TODO: printf both lengths and ms (stringNanos / 1_000_000.0)
        String stringResult = withString();
        long stringNanos = System.nanoTime();

        String builderResult = withBuilder();
        long builderNanos = System.nanoTime() ;

        System.out.printf("String: %d chars, %.2f ms%n", stringResult.length(), stringNanos / 1_000_000.0);

        System.out.printf("StringBuilder: %d chars, %.2f ms%n", builderResult.length(), builderNanos / 1_000_000.0);

    }
}