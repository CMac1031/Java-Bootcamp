public class PerformanceTest {

    private static class SampleObject {
        private final int value;
        private final byte[] data = new byte[64];

        SampleObject(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Performance Measurement =====");
        MemoryMonitor.printMemoryReport("Start");

        int[] objectCounts = {10, 100, 1_000, 100_000, 1_000_000};

        System.out.println();
        System.out.printf("%-12s %-14s %-18s%n", "Objects", "Used Memory", "Execution Time");
        System.out.println("--------------------------------------------------");

        for (int count : objectCounts) {
            runAllocationTest(count);
        }

        System.out.println();
        System.out.println("Additional measurements:");
        measureLoopExecution();
        measureArrayAllocation();
        measureLargeByteArray();
    }

    private static void runAllocationTest(int count) {
        MemoryMonitor.triggerGarbageCollection();
        long memoryBefore = MemoryMonitor.getUsedMemoryBytes();
        long start = System.nanoTime();

        // TODO: allocate SampleObject[count], fill each slot
        SampleObject[] objects = new SampleObject[count];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new SampleObject(i);
        }
        // TODO: measure elapsed ms + memoryUsed; printf row; null array + GC
        long elapsedNanos = System.nanoTime() - start;
        long memoryAfter = MemoryMonitor.getUsedMemoryBytes();
        long memoryUsed = memoryAfter - memoryBefore;

        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);
        double elapsedMillis = elapsedNanos / 1_000_000.0;

        System.out.printf("%-12d %-14s %-18s%n", count, String.format("%.2f MB", memoryUsedMb),
                String.format("%.3f ms", elapsedMillis));
        objects = null;
        MemoryMonitor.triggerGarbageCollection();

    }

    private static void measureLoopExecution() {
        // TODO: loop 10_000_000 iterations summing i into sum; print elapsed ms
        long start = System.nanoTime();
        long sum = 0;

        for (int i = 0; i < 10_000_000; i++) {sum += i;}

        double elapsedMillis = (System.nanoTime() - start) / 1_000_000.0;

        System.out.printf("Loop execution (10M iterations) : %.3f ms | sum = %d%n", elapsedMillis, sum);
    }

    private static void measureArrayAllocation() {
        // TODO: allocate int[1_000_000], fill with i, print elapsed ms
        long start = System.nanoTime();

        int[] numbers = new int[1_000_000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        double elapsedMillis =
                (System.nanoTime() - start) / 1_000_000.0;

        System.out.printf(
                "int[1,000,000] allocation       : %.3f ms%n",
                elapsedMillis);

        numbers = null;
        MemoryMonitor.triggerGarbageCollection();
    }

    private static void measureLargeByteArray() {
        MemoryMonitor.printMemoryReport("Before Large byte[]");
        // TODO: allocate 10 MB byte[]; print After report; null + GC; print After Releasing
        MemoryMonitor.printMemoryReport(
                "Before Large byte[]");

        byte[] largeArray = new byte[10 * 1024 * 1024];
        MemoryMonitor.printMemoryReport("After Large byte[]");

        largeArray = null;
        MemoryMonitor.triggerGarbageCollection();

        MemoryMonitor.printMemoryReport(
                "After Releasing Large byte[]");
    }
}