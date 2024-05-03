public class PrimeCalculator {
    public static void main(String[] args) {
        final int UPPER_LIMIT = 10000; // Use a constant for the limit
        printPrimeNumbers(UPPER_LIMIT);
    }

    private static void printPrimeNumbers(int upperLimit) {
        System.out.println("Prime numbers up to " + upperLimit + ":");
        for (int number = 2; number <= upperLimit; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println(); // Ensures the output ends with a newline
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true; // 2 is the only even prime number
        if (num % 2 == 0) return false; // Exclude all even numbers greater than 2

        for (int i = 3; i * i <= num; i += 2) { // Only test odd factors
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
