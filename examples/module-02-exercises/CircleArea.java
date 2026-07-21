import java.util.Scanner;
import java.lang.Math;
public class CircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Radius: ");
        double r = Double.parseDouble(scanner.nextLine());

        // Area of a circle: π × r²
        double area = Math.PI * Math.pow(r, 2);

        System.out.printf("Area: %.2f%n", area);   // %.2f → two decimal places

        scanner.close();
    }
}