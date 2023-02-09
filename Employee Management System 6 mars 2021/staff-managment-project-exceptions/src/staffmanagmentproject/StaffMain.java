package staffmanagmentproject;// Skapad av Arif och Karin

import staffmanagmentproject.Employee.*;
import static staffmanagmentproject.StaffManagement.*;
import static staffmanagmentproject.menuMethoder.MenuMethods.*;

public class StaffMain {

    public static void main(String[] args) {

        loadDb();
        while (true) {
            int choice = menu();
            switchChoice(choice);
        }

    }

    private static void loadDb() {
        Staff m1 = new Manager("Karin", 25, 38000, "MarcedesBenz");
        Staff m2 = new Manager("karin", 30, 36000, "MazdaNew");
        Staff m3 = new Manager("Sumon", 33, 35000, "Volvo V60");

        Staff p1 = new Programmer("Arif", 30, 33000, 5);
        Staff p2 = new Programmer("arif", 32, 32000, 12);
        Staff p3 = new Programmer("Ebba", 20, 31000, 6);

        Staff j1 = new Janitor("Dalai", 50, 21000, 10);
        Staff j2 = new Janitor("Palash", 40, 21500, 10);
        Staff j3 = new Janitor("Robin", 43, 21100, 12);

        Staff s1 = new Secretary("Nadia", 20, 20800, "Get coffe!");
        Staff s2 = new Secretary("Sara", 21, 20000, "Taking care of social media");
        Staff s3 = new Secretary("Jenni", 22, 19500, "Boil egg");

        myStaff.add(m1);
        myStaff.add(m2);
        myStaff.add(m3);

        myStaff.add(p1);
        myStaff.add(p2);
        myStaff.add(p3);

        myStaff.add(j1);
        myStaff.add(j2);
        myStaff.add(j3);

        myStaff.add(s1);
        myStaff.add(s2);
        myStaff.add(s3);

    }

    public static int menu() {
        System.out.println("===================");
        System.out.println("       MENU        ");
        System.out.println("===================");
        System.out.println("1. Manage Staff Menu");
        System.out.println("2. Print Menu");
        System.out.println("3. Economy Menu");
        System.out.println("4. Statistics Menu");
        System.out.println("5. Sort Employee Menu");
        System.out.println("0. Exit");
        System.out.println("-------------------");
        System.out.println("-------------------");
        System.out.print("Make a Choice: ");
        int choice = readIntNumber();
        return choice;
    }

    private static void switchChoice(int choice) {

        switch (choice) {
            case 1:
                ManageStaffMenu();
                break;

            case 2:
                printStaffMenu();
                break;

            case 3:
                economyMenu();
                break;

            case 4:
                System.out.println("===================");
                staffStatisticsMenu();
                break;

            case 5:
                sortStaffMenu();
                break;

            case 0:
                System.exit(0);
                break;

            default:
                System.out.println("===================");
                System.out.println("Wrong choice! Choose again!");
        }
    }

}
