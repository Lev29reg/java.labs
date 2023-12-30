public class MultiThreadedSum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int length = array.length;

        int midpoint = length / 2;

        SumHolder sumHolder = new SumHolder();

        Thread thread1 = new SumThread(array, 0, midpoint, sumHolder);
        Thread thread2 = new SumThread(array, midpoint, length, sumHolder);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();

            int totalSum = sumHolder.getSum1() + sumHolder.getSum2();
            System.out.println("Общая сумма: " + totalSum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SumHolder {
    private int sum1;
    private int sum2;

    public int getSum1() {
        return sum1;
    }

    public void setSum1(int sum1) {
        this.sum1 = sum1;
    }

    public int getSum2() {
        return sum2;
    }

    public void setSum2(int sum2) {
        this.sum2 = sum2;
    }
}

class SumThread extends Thread {
    private int[] array;
    private int start;
    private int end;
    private SumHolder sumHolder;

    public SumThread(int[] array, int start, int end, SumHolder sumHolder) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.sumHolder = sumHolder;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }

        if (start == 0) {
            sumHolder.setSum1(sum);
        } else {
            sumHolder.setSum2(sum);
        }
    }
}