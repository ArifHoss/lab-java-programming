package week2;

import java.util.Scanner;
import static week2.Calculator.*;

public class CalculatorMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wellcome to my calculator world!");

        boolean loop = true;

        while (loop) {

            System.out.println("1. Addition");
            System.out.println("2. Multiply");
            System.out.println("3. Division");
            System.out.println("4. Subtruction");
            System.out.println("0. Exit");
            System.out.println("Please make a choice");

            int choice = sc.nextInt();

            if (choice < 1 || choice > 4) {
                //loop = false;
                System.exit(0);
            }
            System.out.println("Please now enter your first number:");
            int x = sc.nextInt();
            System.out.println("Please now enter your secound number:");
            int y = sc.nextInt();
            if (choice == 1) {
                addition(x, y);
            } else if (choice == 2) {
                multiply(x, y);
            } else if (choice == 3) {
                division(x, y);

            } else if (choice == 4) {
                subtruction(x, y);

            }

        }

    }

}
