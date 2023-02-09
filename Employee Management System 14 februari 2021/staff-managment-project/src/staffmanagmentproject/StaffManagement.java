package staffmanagmentproject;

import staffmanagmentproject.Employee.Programmer;
import staffmanagmentproject.Employee.Secretary;
import staffmanagmentproject.Employee.Manager;
import staffmanagmentproject.Employee.Janitor;
import java.util.*;

public class StaffManagement {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Staff> myStaff = new ArrayList<>();

    public static Comparator<Staff> sortByName = Comparator.comparing(Staff::getName, String::compareToIgnoreCase);
    public static Comparator<Staff> sortByNameD = Comparator.comparing(Staff::getName, String::compareToIgnoreCase).reversed();

    public static Comparator<Staff> sortByAge = Comparator.comparing(Staff::getAge);
    public static Comparator<Staff> sortByAgeD = Comparator.comparing(Staff::getAge).reversed();

    public static Comparator<Staff> sortBySalary = Comparator.comparing(Staff::getSalary);
    public static Comparator<Staff> sortBySalaryD = Comparator.comparing(Staff::getSalary).reversed();

    public static void addManager() {
        System.out.println("===================");
        System.out.println("Please fill upp information below to add a Manager.");
        System.out.println("===================");

        System.out.print("Name: ");
        String name = readText();

        System.out.print("Age: ");
        int age = limitAge();

        System.out.print("Salary: ");
        double salary = limitSalary();

        System.out.print("Type of car: ");
        String typeOfCar = readText();

        Staff a = new Manager(name, age, salary, typeOfCar);
        myStaff.add(a);
        System.out.println("===================");
        System.out.println("You just added a new Manager as an " + a);
        System.out.println("===================");
    }

    public static void addProgrammer() {
        System.out.println("===================");
        System.out.println("\nPlease fill upp information below to add a Progammer.");
        System.out.println("===================");

        System.out.print("Name: ");
        String name = readText();

        System.out.print("Age: ");
        int age = limitAge();

        System.out.print("Salary: ");
        double salary = limitSalary();

        System.out.print("Number of projects: ");
        int numberOfProject = readIntNumber();

        Staff a = new Programmer(name, age, salary, numberOfProject);
        myStaff.add(a);
        System.out.println("===================");
        System.out.println("You just added a new Programmer as an " + a);
        System.out.println("===================");
    }

    public static void addJanitor() {
        System.out.println("===================");
        System.out.println("\nPlease fill upp information below to add a Janitor.");
        System.out.println("===================");

        System.out.print("Name:");
        String name = readText();

        System.out.print("Age: ");
        int age = limitAge();

        System.out.print("Salary: ");
        double salary = limitSalary();

        System.out.print("Number of tools: ");
        int numberOfTools = readIntNumber();

        Staff a = new Janitor(name, age, salary, numberOfTools);
        myStaff.add(a);
        System.out.println("===================");
        System.out.println("You just added a new Janitor as an " + a);
        System.out.println("===================");
    }

    public static void addSecratary() {
        System.out.println("===================");
        System.out.println("\nPlease fill upp information below to add an Secratary.");
        System.out.println("===================");

        System.out.print("Name:");
        String name = readText();

        System.out.print("Age: ");
        int age = limitAge();

        System.out.print("Salary: ");
        double salary = limitSalary();

        System.out.print("Add task: ");
        String task = readText();

        Staff a = new Secretary(name, age, salary, task);
        myStaff.add(a);
        System.out.println("===================");
        System.out.println("You just added a new Secratary as an " + a);
        System.out.println("===================");
    }

    public static void printAllStaff() {

        for (Staff s : myStaff) {
            System.out.println(s);

        }
        System.out.println("===================");
    }

    public static void printStaffById(int id) {
        boolean repeat = false;

        for (Staff staff : myStaff) {
            if (staff.getId() == id) {
                System.out.println(staff);
                repeat = true;
            }
        }
        if (repeat == false) {
            System.out.println("===================");
            System.out.println("No such employee! Choose again!");
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
            System.out.println("===================");
            System.out.println("No such employee! Choose again!");
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
            System.out.println("===================");
            System.out.println("No such id.");
        }
    }

    public static void updateStaffName(Staff s) {
        System.out.println("===================");
        System.out.print("Write new name: ");
        String newName = readText();
        s.setName(newName);
    }

    public static void updateStaffAge(Staff s) {
        System.out.println("===================");
        System.out.print("Write new age: ");
        int newAge = limitAge();
        s.setAge(newAge);
    }

    public static void updateStaffSalary(Staff s) {
        System.out.println("===================");
        System.out.print("Write new salary: ");
        double newSalary = limitSalary();
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

    public static double totalManagerSalary() {

        double totMSalary = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Manager) {
                totMSalary += staff.salary();
            }
        }

        return totMSalary;
    }

    public static double totalProgrammerSalary() {

        double totPSalary = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Programmer) {
                totPSalary += staff.salary();
            }
        }
        return totPSalary;
    }

    public static double totalSecretarySalary() {

        double totSSalary = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Secretary) {
                totSSalary += staff.salary();
            }
        }
        return totSSalary;
    }

    public static double totalJanitorSalary() {

        double totJSalary = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Janitor) {
                totJSalary += staff.salary();
            }
        }
        return totJSalary;
    }

    public static void calculateBonus() {
        for (Staff b : myStaff) {
            b.bonus();
            System.out.println("Calculated bonus " + b.bonus() + " --- Specification for this " + b);

        }
    }

    public static void totalCompanyBonus() {

        double totBonus = 0;
        for (Staff staff : myStaff) {
            totBonus += staff.bonus();
        }
        System.out.println("===================");
        System.out.println("Total company bonus: " + totBonus);
        System.out.println("===================");
    }

    public static void managersBonus() {

        double mBonus = 0;

        for (Staff s : myStaff) {
            if (s instanceof Manager) {
                mBonus = s.bonus() + mBonus;
            }
        }
        System.out.println("===================");
        System.out.println("Total managers bonus: " + mBonus);
        System.out.println("===================");

    }

    public static void programmersBonus() {

        double pbonus = 0;

        for (Staff s : myStaff) {

            if (s instanceof Programmer) {
                pbonus = s.bonus() + pbonus;

            }
        }
        System.out.println("===================");
        System.out.println("Total programmers bonus: " + pbonus);
        System.out.println("===================");
    }

    public static void secretariesBonus() {

        double sbonus = 0;

        for (Staff staff : myStaff) {

            if (staff instanceof Secretary) {
                sbonus = staff.bonus() + sbonus;
            }
        }
        System.out.println("===================");
        System.out.println("Total secretaries bonus: " + sbonus);
        System.out.println("===================");
    }

    public static void janitorsBonus() {

        double jbonus = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Janitor) {
                jbonus = staff.bonus() + jbonus;

            }

        }
        System.out.println("===================");
        System.out.println("Total Janitors bonus: " + jbonus);
        System.out.println("===================");
    }

    public static void averageCompanySalary() {
        double sum = 0;
        for (Staff s : myStaff) {
            sum = sum + s.getSalary();

        }
        double average = sum / myStaff.size();
        System.out.println("===================");
        System.out.println("Average salary for this company: " + average);
        System.out.println("===================");

    }

    public static void averageManagerDepSalary() {

        int numberOfManager = 0;

        for (Staff staff : myStaff) {

            if (staff instanceof Manager) {

                numberOfManager++;

            }

        }
        System.out.println("===================");
        System.out.println("Average salary for managers is: " + totalManagerSalary() / numberOfManager);
        System.out.println("===================");
    }

    public static void averageProgrammerDepSalary() {

        int numberOfProg = 0;

        for (Staff staff : myStaff) {
            if (staff instanceof Programmer) {
                numberOfProg++;
            }
        }
        System.out.println("===================");
        System.out.println("Average salary for programmers is: " + totalProgrammerSalary() / numberOfProg);
        System.out.println("===================");
    }

    public static void averageSecretaryDepSalary() {

        int numberOfSecret = 0;

        for (Staff staff : myStaff) {

            if (staff instanceof Secretary) {
                numberOfSecret++;
            }
        }
        System.out.println("===================");
        System.out.println("Average salary for secretarys is: " + totalSecretarySalary() / numberOfSecret);
        System.out.println("===================");
    }

    public static void averageJanitorDepSalary() {

        int numberOfJani = 0;

        for (Staff staff : myStaff) {

            if (staff instanceof Janitor) {
                numberOfJani++;
            }
        }
        System.out.println("===================");
        System.out.println("Average salary for janotors is: " + totalJanitorSalary() / numberOfJani);
        System.out.println("===================");
    }

    public static void maxSalary() {

        int max = 0;

        for (int i = 0; i < myStaff.size(); i++) {
            if (myStaff.get(max).getSalary() < myStaff.get(i).getSalary()) {
                max = i;
            }
        }
        System.out.println("===================");
        System.out.println("Highest salary in this company is: " + myStaff.get(max).getSalary());
        System.out.println("===================");
    }

    public static void minimumSalary() {
        int min = 0;
        for (int i = 0; i < myStaff.size(); i++) {
            if (myStaff.get(min).getSalary() > myStaff.get(i).getSalary()) {
                min = i;
            }

        }
        System.out.println("===================");
        System.out.println("Lowest salary in this company is: " + myStaff.get(min).getSalary());
        System.out.println("===================");

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
                sc.nextLine();
                System.out.println("\nWrite text only please!");
                System.out.println("-------------------------");
                System.out.print("Try again: ");
            }
        }

        return null;
    }// This metod is to catch variable MismatchException!

    public static int limitAge() {

        boolean repeat = true;
        while (repeat) {
            int age = readIntNumber();

            if (age > 17 && age < 68) {
                repeat = false;
                return age;
            } else {
                System.out.println("Age must be between 18 to 68!");
                System.out.print("Age: ");
            }
        }
        return -1;
    }

    public static double limitSalary() {

        boolean repeat = true;
        while (repeat) {
            double salary = readDoubleNumber();
            if (salary > 15000 && salary < 150000) {
                repeat = false;
                return salary;
            }else {
                System.out.println("Salary must be between 15000 to 1 50 000!");
                System.out.print("Salary: ");
            }
        }

        return -1;
    }
}
