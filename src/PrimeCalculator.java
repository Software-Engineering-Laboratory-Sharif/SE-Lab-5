public class PrimeCalculator {
    public static void main(String[] args) {
        final int UPPER_LIMIT = 10000;
        printPrimeNumbers(UPPER_LIMIT);
    }

    private static void printPrimeNumbers(int upperLimit) {
        System.out.println("Prime numbers up to " + upperLimit + ":");
        for (int number = 2; number <= upperLimit; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
