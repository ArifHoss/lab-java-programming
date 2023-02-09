package staffmanagmentproject;

import java.util.*;

public class StaffManagement {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Staff> myStaff = new ArrayList<>();

    public static void addStaff() {
        System.out.println("These are the employees we have.");
        System.out.println("===================");
        printAllStaff();
        System.out.println("===================");
        System.out.println("What type of employee you want to add?");
        System.out.println("1. Manager: ");
        System.out.println("2. Programmer: ");
        System.out.println("3. Janitor: ");
        System.out.println("4. Secratary: ");
        System.out.println("Typ any other number to back to the main menu.");
        System.out.println("===================");
        System.out.print("\nMake a choice: ");
        int choice = readIntNumber();

        switch (choice) {
            case 1:
                addManager();
                break;

            case 2:
                addProgrammer();
                break;

            case 3:
                addJanitor();
                break;

            case 4:
                addSecratary();
                break;

            default:
                System.out.println("Choose again from main menu.");

        }

    }//This metod contain menu! 

    public static void addManager() {
        System.out.println("\nPlease fill upp information below to add a Manager.");
        System.out.println("===================");

        System.out.print("Staff Name: ");
        String name = readText();

        System.out.print("Staff Age: ");
        int age = readIntNumber();

        System.out.print("Staff Salary: ");
        double salary = readDoubleNumber();

        System.out.print("Type of car: ");
        String typeOfCar = readText();

        Staff a = new Manager(name, age, salary, typeOfCar);
        myStaff.add(a);
        System.out.println("You just added a new Manager as an " + a);
        System.out.println("===================");
    }

    public static void addProgrammer() {
        System.out.println("\nPlease fill upp information below to add a Progammer.");
        System.out.println("===================");

        System.out.print("Staff Name: ");
        String name = readText();

        System.out.print("Staff Age: ");
        int age = readIntNumber();

        System.out.print("Staff Salary: ");
        double salary = readDoubleNumber();

        System.out.print("Number of projects: ");
        int numberOfProject = readIntNumber();

        Staff a = new Programmer(name, age, salary, numberOfProject);
        myStaff.add(a);
        System.out.println("You just added a new Programmer as an " + a);
    }

    public static void addJanitor() {
        System.out.println("\nPlease fill upp information below to add a Janitor.");
        System.out.println("===================");

        System.out.print("Staff Name:");
        String name = readText();

        System.out.print("Staff Age: ");
        int age = readIntNumber();

        System.out.print("Staff Salary: ");
        double salary = readDoubleNumber();

        System.out.print("Number of tools: ");
        int numberOfTools = readIntNumber();

        Staff a = new Janitor(name, age, salary, numberOfTools);
        myStaff.add(a);
        System.out.println("You just added a new Janitor as an" + a);
    }

    public static void addSecratary() {
        System.out.println("\nPlease fill upp information below to add an Secratary.");
        System.out.println("===================");

        System.out.print("Staff Name:");
        String name = readText();

        System.out.print("Staff Age: ");
        int age = readIntNumber();

        System.out.print("Staff Salary: ");
        double salary = readDoubleNumber();

        System.out.print("Add task: ");
        String task = readText();

        Staff a = new Secretary(name, age, salary, task);
        myStaff.add(a);
        System.out.println("You just added a new Secratary as an " + a);
    }

    public static void printAllStaff() {

        for (Staff s : myStaff) {
            System.out.println(s);

        }
        System.out.println("===================");
    }

    public static void printStaffById(int id) {
//        Staff s = findStaffById(id);
//        if (s != null) {
//            System.out.println(s);
//        } else {
//            System.out.println("No employee with this ID.");
//        }
        boolean repeat = false;

        for (Staff staff : myStaff) {
            if (staff.getId() == id) {
                repeat = true;
                System.out.println(staff);
            }
        }
        if (repeat == false) {
            System.out.println("No such employee! Choose again from main menu!");
        }
    }

    public static void printStaffByName(String name) {

        boolean repeat = false;

        for (Staff staff : myStaff) {
            if (staff.getName().equalsIgnoreCase(name)) {
                System.out.println(staff);
                repeat = true;
            }
        }
        if (repeat == false) {
            System.out.println("No such employee! Choose again from main menu!");
        }
    }

    public static Staff findStaffById(int id) {
        for (Staff staff : myStaff) {
            if (staff.getId() == id) {
                return staff;
            }
        }
        return null;
    }

    public static void removeStaffById(int id) {
        Staff s = findStaffById(id);
        if (s != null) {
            myStaff.remove(s);
            System.out.println("=======================");
            System.out.println("Removed " + s);
            System.out.println("=======================");
        } else {
            System.out.println("No such id.");
        }
    }

    public static void updateStaff(int id) {

        Staff s = findStaffById(id);

        if (s != null) {
            System.out.println("===================");
            System.out.println("What do want to update?");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Salary");

            if (s instanceof Manager) {
                System.out.println("4. Type of car for a manager");

            } else if (s instanceof Programmer) {
                System.out.println("4. Number of project for a programmer");

            } else if (s instanceof Secretary) {
                System.out.println("4. Update secratarys task");

            } else if (s instanceof Janitor) {
                System.out.println("4. Update janitors number of tools");

            }
            System.out.println("0. All");
            System.out.println("===================");
            System.out.print("\nMake a choice: ");

            int choice = readIntNumber();

            switch (choice) {
                case 1:
                    updateStaffName(s);
                    break;

                case 2:
                    updateStaffAge(s);
                    break;

                case 3:
                    updateStaffSalary(s);
                    break;
                case 4:
                    if (s instanceof Manager) {
                        updateManagerCar((Manager) s);
                        System.out.println("Updated new type of manager car: " + s);

                    } else if (s instanceof Programmer) {
                        updateProject((Programmer) s);

                    } else if (s instanceof Secretary) {
                        updateSecrataryTask((Secretary) s);

                    } else if (s instanceof Janitor) {
                        updateJanitorTools((Janitor) s);
                    }
                    break;

                case 0:
                    updateStaffName(s);
                    updateStaffAge(s);
                    updateStaffSalary(s);

                    if (s instanceof Manager) {
                        updateManagerCar((Manager) s);

                    } else if (s instanceof Programmer) {
                        updateProject((Programmer) s);

                    } else if (s instanceof Secretary) {
                        updateSecrataryTask((Secretary) s);

                    } else if (s instanceof Janitor) {
                        updateJanitorTools((Janitor) s);
                    }
                    break;

                default:
                    System.out.println("Choose again from main menu.");

            }
        } else {
            System.out.println("NO EMPLOYEE WITH THIS ID!");
        }
    }//This metod contain menu!***

    public static void updateStaffName(Staff s) {
        System.out.println("===================");
        System.out.print("Write new name: ");
        String newName = readText();
        s.setName(newName);
    }

    public static void updateStaffAge(Staff s) {
        System.out.println("===================");
        System.out.print("Write new age: ");
        int newAge = readIntNumber();
        s.setAge(newAge);
    }

    public static void updateStaffSalary(Staff s) {
        System.out.println("===================");
        System.out.print("Write new salary: ");
        double newSalary = readDoubleNumber();
        s.setSalary(newSalary);
    }

    public static void updateManagerCar(Manager s) {
        System.out.println("===================");
        System.out.print("Write new car to update: ");
        String newCar = readText();
        s.setTypeOfCar(newCar);
    }

    public static void updateProject(Programmer s) {
        System.out.println("===================");
        System.out.print("Write new total number of project: ");
        int newProject = readIntNumber();
        s.setNumberOfProject(newProject);

    }

    public static void updateSecrataryTask(Secretary s) {
        System.out.println("===================");
        System.out.print("Write new task for Secretary: ");
        String newTask = readText();
        s.setTask(newTask);

    }

    public static void updateJanitorTools(Janitor s) {
        System.out.println("===================");
        System.out.print("Write new total number of tools: ");
        int newTools = readIntNumber();
        s.setNumberOfTools(newTools);
    }

    public static void totalCompanySalary() {
        double totSalary = 0;
        for (Staff staff : myStaff) {
            totSalary += staff.salary();

        }
        System.out.println("Calculated all employee salary: " + totSalary);

    }

    public static void salaryByDepartment() {

        System.out.println("\nChoose department");
        System.out.println("====================");
        System.out.println("1. Manegers");
        System.out.println("2. Programmers");
        System.out.println("3. Secretaries");
        System.out.println("4. Janitors");
        System.out.println("OR. Press any other number to back to the main menu!");
        System.out.println("===================");
        System.out.print("Make a choice: ");

        int choice = readIntNumber();

        switch (choice) {

            case 1:
                totalManagerSalary();
                break;

            case 2:
                totalProgrammerSalary();
                break;

            case 3:
                totalSecretarySalary();
                break;

            case 4:
                totalJanitorSalary();
                break;

            default:
                System.out.println("Choose again from main menu.");
        }
    }//This metod contain menu!***

    public static double totalManagerSalary() {

        double totMSalary = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Manager) {
                totMSalary += staff.salary();
            }
        }
        System.out.println("Total manager department salary: " + totMSalary + " kr.");

        return totMSalary;
    }

    public static double totalProgrammerSalary() {

        double totPSalary = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Programmer) {
                totPSalary += staff.salary();
            }
        }
        System.out.println("Total programmer department salary: " + totPSalary + " kr.");
        return totPSalary;
    }

    public static double totalSecretarySalary() {

        double totSSalary = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Secretary) {
                totSSalary += staff.salary();
            }
        }
        System.out.println("Total secretary department salary: " + totSSalary + " kr.");
        return totSSalary;
    }

    public static double totalJanitorSalary() {

        double totJSalary = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Janitor) {
                totJSalary += staff.salary();
            }
        }
        System.out.println("Total janitor department salary: " + totJSalary + " kr.");
        return totJSalary;
    }

    public static void calculateBonus() {
        for (Staff b : myStaff) {
            b.bonus();
            System.out.println("Calculated bonus " + b.bonus() + " --- Specification for this " + b);

        }
    }

    public static void staffStatistics() {

        System.out.println("\nWhat do you want to do.?");
        System.out.println("=====================");
        System.out.println("1. Calculate total company bonus.");
        System.out.println("2. Calculate bonus for each departement.***");
        System.out.println("3. Calculate salary for each department.***");
        System.out.println("4. Show average salary.");
        System.out.println("5. Show average salary in each department.***");// inte klart än
        System.out.println("6. Show highest salary in the company.");
        System.out.println("7. Show lowest salary in the company.");

        System.out.println("OR. Press any other number to back to the main manu");
        System.out.println("======================");
        System.out.print("Make a choice: ");
        int choice = readIntNumber();

        switch (choice) {
            case 1:
                totalCompanyBonus();
                break;

            case 2:
                bonusBylDepartment();
                break;

            case 3:
                salaryByDepartment();
                break;

            case 4:
                averageCompanySalary();
                break;

            case 5:
                averageSalaryByDepartement();
                break;

            case 6:
                maxSalary();
                break;

            case 7:
                minimumSalary();
                break;

            default:
                System.out.println("Choose again from main menu.");
        }
    }//This metod contain menu!***

    public static void totalCompanyBonus() {
        double totBonus = 0;
        for (Staff i : myStaff) {
            totBonus += i.bonus();

        }
        System.out.println("Total company bonus: " + totBonus);
    }

    public static void bonusBylDepartment() {

        System.out.println("\nChoose department");
        System.out.println("====================");
        System.out.println("1. Manegers");
        System.out.println("2. Programmers");
        System.out.println("3. Secretaries");
        System.out.println("4. Janitors");
        System.out.println("0. Back to the main menu");
        System.out.print("Make a choice: ");

        int choice = readIntNumber();

        switch (choice) {

            case 1:
                managersBonus();
                break;

            case 2:
                programmersBonus();
                break;

            case 3:
                secretariesBonus();
                break;

            case 4:
                janitorsBonus();
                break;

            default:
                System.out.println("Choose again from main menu.");
        }

    }//This metod contain menu!***

    public static void managersBonus() {

        double mBonus = 0;

        for (Staff s : myStaff) {
            if (s instanceof Manager) {
                mBonus = s.bonus() + mBonus;
            }
        }

        System.out.println("Total managers bonus: " + mBonus);

    }

    public static void programmersBonus() {

        double pbonus = 0;

        for (Staff s : myStaff) {

            if (s instanceof Programmer) {
                pbonus = s.bonus() + pbonus;

            }
        }
        System.out.println("Total programmers bonus: " + pbonus);
    }

    public static void secretariesBonus() {

        double sbonus = 0;

        for (Staff staff : myStaff) {

            if (staff instanceof Secretary) {
                sbonus = staff.bonus() + sbonus;
            }
        }
        System.out.println("Total secretaries bonus: " + sbonus);
    }

    public static void janitorsBonus() {

        double jbonus = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Janitor) {
                jbonus = staff.bonus() + jbonus;

            }

        }
        System.out.println("Total Janitors bonus: " + jbonus);
    }

    public static void averageCompanySalary() {
        double sum = 0;
        for (Staff s : myStaff) {
            sum = sum + s.getSalary();

        }
        double average = sum / myStaff.size();
        System.out.println(average);

    }

    public static void averageSalaryByDepartement() {
        System.out.println("\nChoose department");
        System.out.println("====================");
        System.out.println("1. Manegers");
        System.out.println("2. Programmers");
        System.out.println("3. Secretaries");
        System.out.println("4. Janitors");
        System.out.println("OR. Press any other number to back to the main menu!");
        System.out.print("Make a choice: ");

        int choice = readIntNumber();

        switch (choice) {

            case 1:
                averageManagerDepSalary();
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            default:
                System.out.println("Choose again from main menu.");
        }
    }//This metod contain menu!***

    public static void averageManagerDepSalary() {

        int numberOfManager = 0;

        for (Staff staff : myStaff) {

            if (staff instanceof Manager) {

                numberOfManager++;

            }

        }
        System.out.println("Average salary for managers is: " + totalManagerSalary() / numberOfManager);
    }

    public static void averageProgrammerDepSalary() {

        int numberOfProg = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Programmer) {
                numberOfProg++;
            }
        }
        System.out.println("Average salary for programmers is: " + totalProgrammerSalary() / numberOfProg);
    }

    public static void averageSecretaryDepSalary() {

        int numberOfSecret = 0;

        for (Staff staff : myStaff) {

            if (staff instanceof Secretary) {
                numberOfSecret++;
            }
        }
        System.out.println("Average salary for secretarys is: " + totalSecretarySalary() / numberOfSecret);
    }

    public static void averageJanitorDepSalary() {

        int numberOfJani = 0;

        for (Staff staff : myStaff) {

            if (staff instanceof Janitor) {
                numberOfJani++;
            }
        }
        System.out.println("Average salary for janotors is: " + totalJanitorSalary() / numberOfJani);
    }

    public static void maxSalary() {

        int max = 0;

        for (int i = 0; i < myStaff.size(); i++) {
            if (myStaff.get(max).getSalary() < myStaff.get(i).getSalary()) {
                max = i;
            }
        }
        System.out.println("Highest salary in this company is: "+myStaff.get(max).getSalary());
    }

    public static void minimumSalary() {
        int min = 0;
        for (int i = 0; i < myStaff.size(); i++) {
            if (myStaff.get(min).getSalary() > myStaff.get(i).getSalary()) {
                min = i;
            }

        }
        System.out.println("Lowest salary in this company is: "+myStaff.get(min).getSalary());

    }

    public static double readDoubleNumber() {

        boolean repeat = true;

        while (repeat) {
            try {
                double readNumber = sc.nextDouble();
                sc.nextLine();
                repeat = false;
                return readNumber;

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Choose numaric values only please!");
                System.out.println("------------------");
                System.out.print("Try again: ");
            }
        }
        return 0;
    }// This metod is to catch variable MismatchException!

    public static int readIntNumber() {
        boolean repeat = true;
        while (repeat) {
//            System.out.print(s);
            try {
                int readNumber = sc.nextInt();
                sc.nextLine();
                repeat = false;
                return readNumber;

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Choose numaric values only please!");
                System.out.println("---------------------");
                System.out.print("Try again: ");
            }
        }
        return -1;
    }// This metod is to catch variable MismatchException!

    public static String readText() {

        boolean repeat = true;

        while (repeat) {

            try {
                String textReader = sc.nextLine();
                repeat = false;

                return textReader;

            } catch (InputMismatchException e) {
                System.out.println("\nWrite text only OR press 0 to go to main manu!");
                System.out.println("-------------------------");
                System.out.print("Try again: ");
            }
        }

        return null;
    }// This metod is to catch variable MismatchException!
}
