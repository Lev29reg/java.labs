import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class Warehouse {
    private final List<Integer> weights;

    public Warehouse(List<Integer> weights) {
        this.weights = weights;
    }

    public CompletableFuture<Void> moveGoodsAsync() {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            List<CompletableFuture<Void>> tasks = new ArrayList<>();

            int currentIndex = 0;

            while (currentIndex < weights.size()) {
                int remainingWeight = 150;
                List<Integer> currentBatch = new ArrayList<>();

                while (currentIndex < weights.size() && remainingWeight >= weights.get(currentIndex)) {
                    int currentWeight = weights.get(currentIndex);
                    currentBatch.add(currentWeight);
                    remainingWeight -= currentWeight;
                    currentIndex++;
                }

                tasks.add(moveGoodsBatchAsync(currentBatch));
            }

            CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();
        });

        return completableFuture;
    }

    private CompletableFuture<Void> moveGoodsBatchAsync(List<Integer> batch) {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Loading goods: " + batch);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Goods loaded: " + batch);
        }).thenRunAsync(() -> {
            System.out.println("Unloading goods: " + batch);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Goods unloaded: " + batch);
        });
    }
}

public class MultiThreadedWarehouse {
    public static void main(String[] args) {
        List<Integer> weights = List.of(30, 50, 20, 40, 60, 10, 30, 50, 10, 20);

        Warehouse warehouse = new Warehouse(weights);

        CompletableFuture<Void> moveGoodsFuture = warehouse.moveGoodsAsync();

        try {
            moveGoodsFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
