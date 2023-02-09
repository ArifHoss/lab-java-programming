package staffmanagmentproject;// Skapad av Arif och Karin

import static staffmanagmentproject.StaffManagement.*;

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
        Staff m2 = new Manager("Karin", 30, 28000, "MazdaNew");
        Staff m3 = new Manager("Sumon", 33, 38000, "Volvo V60");

        Staff p1 = new Programmer("Arif", 30, 25000, 5);
        Staff p2 = new Programmer("Arif", 32, 25500, 12);
        Staff p3 = new Programmer("Ebba", 20, 22000, 6);

        Staff j1 = new Janitor("Dalai", 50, 5000, 10);
        Staff j2 = new Janitor("Dalai", 40, 16000, 10);
        Staff j3 = new Janitor("Robi", 43, 15500, 12);
        
        Staff s1 = new Secretary("Nadia", 20, 12000, "Hämta coffe");
        Staff s2 = new Secretary("Sara", 21, 12000, "Takeing care social media");
        Staff s3 = new Secretary("Jeni", 22, 13000, "Boile egg");
        
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
        System.out.println("1. Add Staff***");
        System.out.println("2. Print All Staff");
        System.out.println("3. Print Staff By ID");
        System.out.println("4. Print Staff by Name");
        System.out.println("5. Update Staff***");
        System.out.println("6. Remove Staff");
        System.out.println("7. Clculate salary");
        System.out.println("8. Calculate bonus");
        System.out.println("9. Statistics***");
        System.out.println("0. Exit");
        System.out.print("\nChoose number from menu: ");

        int choice = readIntNumber();
        return choice;
    }

    private static void switchChoice(int choice) {
       
        switch (choice) {
            case 1:
                addStaff();
                break;

            case 2:
                printAllStaff();
                break;

            case 3:
                System.out.println("===================");
                System.out.print("Write an employees ID: ");
                int ID = readIntNumber();
                printStaffById(ID);
                break;
                
            case 4:
                System.out.println("===================");
                System.out.print("Write an employee Name: ");
                String name = readText();
                printStaffByName(name);
                break;
                

            case 5:
                printAllStaff();
                System.out.print("Write ID number to update: ");
                int findIdToUpdate = readIntNumber();
                updateStaff(findIdToUpdate);
                break;

            case 6:
                printAllStaff();
                System.out.print("\nWrite ID number to remove from employee list: ");
                int id = readIntNumber();
                removeStaffById(id);
                break;

            case 7:
                totalCompanySalary();
                break;

            case 8:
                calculateBonus();
                break;

            case 9:
                staffStatistics();
                break;

            case 0:
                System.exit(0);
                break;

            default:
                System.out.println("\nWrong choice! Choose number(0-7)");
        }
    }

}
