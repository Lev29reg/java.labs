public class MultiThreadedMatrixMax {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 3},
                {8, 2, 4},
                {6, 9, 7}
        };

        int numRows = matrix.length;

        MaxElementHolder maxElementHolder = new MaxElementHolder();

        Thread[] threads = new Thread[numRows];

        for (int i = 0; i < numRows; i++) {
            threads[i] = new MaxThread(matrix[i], maxElementHolder);
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }

            int maxElement = maxElementHolder.getMaxElement();
            System.out.println("Наибольший элемент матрицы: " + maxElement);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MaxElementHolder {
    private int maxElement = Integer.MIN_VALUE;

    public synchronized int getMaxElement() {
        return maxElement;
    }

    public synchronized void updateMaxElement(int value) {
        if (value > maxElement) {
            maxElement = value;
        }
    }
}

class MaxThread extends Thread {
    private int[] row;
    private MaxElementHolder maxElementHolder;

    public MaxThread(int[] row, MaxElementHolder maxElementHolder) {
        this.row = row;
        this.maxElementHolder = maxElementHolder;
    }

    @Override
    public void run() {
        int maxInRow = Integer.MIN_VALUE;

        // Поиск наибольшего элемента в строке
        for (int value : row) {
            if (value > maxInRow) {
                maxInRow = value;
            }
        }

        maxElementHolder.updateMaxElement(maxInRow);
    }
}