package week2;

import java.util.Scanner;
import static week2.CalculatorSwitch.*;//här importerar jag alla static metoder

public class CalculatorMainSwitch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to my first java 'Calculator':");
        boolean run = true;
        while (run) {
            System.out.println("Please make a choice:");
            System.out.println("1. Addition ");
            System.out.println("2. Multiply");
            System.out.println("3. Division");
            System.out.println("4. Substruction");
            System.out.println("0. Press 0 for exit.");
            int choice = sc.nextInt();
            if (choice < 1 || choice > 4) {
                System.exit(0);
            }
            System.out.println("Please enter your first number:");
            double a = sc.nextDouble();
            System.out.println("Please enter your secound number:");
            double b = sc.nextDouble();
            switch (choice) {
                case 1:
                    addtion(a, b);
                    break;
                case 2:
                    multiply(a, b);
                    break;
                case 3:
                    division(a, b);
                    break;
                case 4:
                    substruction(a, b);
                    break;
                default:
                    System.out.println("Felaktig val! Välje en av följande: ");
            }
        }
    }
}
