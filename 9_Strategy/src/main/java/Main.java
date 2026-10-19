import java.util.Random;
public class Main {
    public static void main(String[] args){
        int[] smallData = generateRandomArray(30);
        int[] largeData = generateRandomArray(100000);

        SortingStrategy[] strategies = {
                new BubbleSortStrategy(),
                new MergeSortStrategy(),
                new QuickSortStrategy()
        };

        System.out.println("----SMALL DATASET----");
        testStrategies(smallData, strategies);

        System.out.println("\n----LARGE DATASET----");
        testStrategies(largeData, strategies);
    }

    private static void testStrategies(int[] original, SortingStrategy[] strategies){
        SortContext context = new SortContext();

        for(SortingStrategy strategy: strategies){
            int[] copy = original.clone();

            context.setStrategy(strategy);

            long startTime = System.nanoTime();

            context.sort(copy);

            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.printf("%-15s : %.3f ms%n",
                    context.getStrategyName(),
                    duration/ 1_000_000.0);
        }
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();

        int[] data = new int[size];

        for(int i = 0; i < size; i ++){
            data[i] = random.nextInt(1000000);
        }

        return data;
    }
}
