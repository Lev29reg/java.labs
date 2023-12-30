public class Primes {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++)
            if (isPrime(i))
                System.out.println(i);
    }

    public static boolean isPrime(int n) {
        boolean prime = true;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}