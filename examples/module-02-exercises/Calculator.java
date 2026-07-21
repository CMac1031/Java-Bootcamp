import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First number: ");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.print("Second number: ");
        double b = Double.parseDouble(scanner.nextLine());

        System.out.printf("Sum: %.2f%n", sum(a, b));          // addition
        System.out.printf("Difference: %.2f%n", difference(a, b));   // subtraction
        System.out.printf("Product: %.2f%n", product(a, b));      // multiplication
        System.out.printf("Quotient: %.2f%n", quotient(a, b));     // division (double ÷ double)
        System.out.printf("Mod: %.2f%n", mod(a,b));

        scanner.close();
    }

    public static double sum(double a, double b) {
        double sum = a + b;
        return sum;
    }

    public static double difference(double a, double b) {
        double difference = a - b;
        return difference;
    }

    public static double product(double a, double b) {
        double product = a * b;
        return product;
    }

    public static double quotient(double a, double b) {
        double quotient = a / b;
        return quotient;
    }
    public static double mod(double a, double b) {
        double  mod = a % b;
        return mod;
    }
}