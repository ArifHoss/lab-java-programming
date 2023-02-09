package lab1cirkle;//Lab av Arif Hossain och Karin Ismel

import java.util.Scanner;

public class GeometricShapes {

    static Scanner sc = new Scanner(System.in);
    static boolean loop = true;

    public static void main(String[] args) {

        while (loop) {
            start();

        }

    }

    private static void start() {
        System.out.println("Vilken geometrisk figur vill du jobba med? ");
        System.out.println("1. Cirkel");
        System.out.println("2. Rektangel");
        System.out.println("3. Triangel");
        System.out.println("0. Exit");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                circleCalculations(choice);
                break;
            case 2:
                rektangelCalculations(choice);
                break;
            case 3:
                triangelCalculations(choice);
                break;
            case 0:
                loop = false;
                break;
            default:
                System.out.println("Ogiltigt val! Välj något av följande!");
        }
    }

    private static void triangelCalculations(int choice) {
        System.out.println("Ange följande: ");
        System.out.println("Bas:");
        double base = sc.nextDouble();

        System.out.println("Hight: ");
        double hight = sc.nextDouble();

        System.out.println("Side 1: ");
        double side1 = sc.nextDouble();

        System.out.println("Side 2: ");
        double side2 = sc.nextDouble();
        
        Triangel tri = new Triangel(base, hight, side1, side2);

        System.out.println("1.Area");
        System.out.println("2. Omkrets");
        
        int choice3 = sc.nextInt();

        if (choice3 == 1) {
            System.out.println("Arean på din Triangel med basen " + base + "och med hight är: " + tri.area());
        } else if (choice3 == 2) {
            System.out.println("Omkrets på din Triangel med basen " + base + " , sidan 1 " + side1 + " och sidan 2 är: " + tri.circumreference());
        }

    }

    private static void rektangelCalculations(int choice) {
        System.out.println("Ange följande: ");
        System.out.println("Bas: ");
        double base = sc.nextDouble();
        System.out.println("Höjd: ");
        double hight = sc.nextDouble();
        Rektangel rekt = new Rektangel(base, hight);

        System.out.println("1. Omkrets");
        System.out.println("2. Area");
        int choice2 = sc.nextInt();

        if (choice2 == 1) {
            System.out.println("Rektangels omkrets är: " + rekt.circumreference());
        } else if (choice2 == 2) {
            System.out.println("Rektangels area är: " + rekt.area());
        }
    }

    private static void circleCalculations(int choice) {
        System.out.println("Ange följande: ");
        System.out.print("Radie: ");
        double r = sc.nextDouble();
        Circle c = new Circle(r);
        System.out.println("1. Omkrets");
        System.out.println("2. Area");
        int choice1 = sc.nextInt();

        if (choice1 == 1) {
            System.out.println("Circle omkrets med radie " + r + " är: " + c.circumreference());
        } else if (choice1 == 2) {
            System.out.println("Circle area med radie " + r + " är: " + c.area());
        }
    }

}
