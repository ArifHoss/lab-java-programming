package staffmanagmentproject.menuMethoder;

import staffmanagmentproject.Employee.Programmer;
import staffmanagmentproject.Employee.Secretary;
import staffmanagmentproject.Employee.Manager;
import staffmanagmentproject.Employee.Janitor;
import staffmanagmentproject.*;
import static staffmanagmentproject.StaffManagement.*;

public class MenuMethods {

    public static void ManageStaffMenu() {
        System.out.println("===================");
        System.out.println("These are the employees we have.");
        System.out.println("===================");
        printAllStaff();

        boolean loop = true;
        while (loop) {

            System.out.println("  MANAGE STAFF MENU   ");
            System.out.println("===================");
            System.out.println("1. Add Manager ");
            System.out.println("2. Add Programmer ");
            System.out.println("3. Add Janitor ");
            System.out.println("4. Add Secratary ");
            System.out.println("5. Remove an Employee");
            System.out.println("6. Update Employee");
            System.out.println("0. Main menu");
            System.out.println("===================");
            System.out.print("Make a choice: ");

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

                case 5:
                    System.out.println("===================");
                    printAllStaff();
                    System.out.print("\nWrite ID number to remove from employee list: ");
                    int id = readIntNumber();
                    System.out.println("===================");
                    removeStaffById(id);
                    break;

                case 6:
                    System.out.println("===================");
                    printAllStaff();
                    System.out.print("Write ID number to update: ");
                    int findIdToUpdate = readIntNumber();
                    System.out.println("===================");
                    updateStaffMenu(findIdToUpdate);
                    break;

                case 0:
                    loop = false;
                    break;

                default:
                    System.out.println("===================");
                    System.out.println("Wrong choice! Choose again!");
                    System.out.println("===================");

            }
        }

    }

    public static void printStaffMenu() {

        boolean loop = true;
        while (loop) {
            System.out.println("===================");
            System.out.println("       PRINT   ");
            System.out.println("===================");
            System.out.println("1. Print All Staff");
            System.out.println("2. Print Staff By ID");
            System.out.println("3. Print Staff by Name");
            System.out.println("0. Main Menu");
            System.out.println("===================");
            System.out.print("Make a choice: ");

            int choice = readIntNumber();

            switch (choice) {
                case 1:
                    printAllStaff();
                    break;

                case 2:
                    System.out.println("===================");
                    System.out.print("Write an employees ID: ");
                    int ID = readIntNumber();
                    System.out.println("===================");
                    printStaffById(ID);
                    break;

                case 3:
                    System.out.println("===================");
                    System.out.print("Write an employee Name: ");
                    String name = sc.nextLine();
                    System.out.println("===================");
                    printStaffByName(name);
                    break;

                case 0:
                    loop = false;
                    break;

                default:
                    System.out.println("===================");
                    System.out.println("Wrong choice! Choose again!");
                    System.out.println("===================");
            }
        }
    }

    public static void updateStaffMenu(int id) {

        Staff s = findStaffById(id);

        if (s != null) {

            System.out.println("===================");
            System.out.println(" STAFF UPDATE MENU ");
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
            System.out.println("5. All");
            System.out.println("0. Manage Menu");
            System.out.println("===================");
            System.out.print("Make a choice: ");

            int choice = readIntNumber();

            switch (choice) {
                case 1:
                    updateStaffName(s);
                    System.out.println("===================");
                    System.out.println("Updated this " + s);
                    break;

                case 2:
                    updateStaffAge(s);
                    System.out.println("===================");
                    System.out.println("Updated this " + s);
                    break;

                case 3:
                    updateStaffSalary(s);
                    System.out.println("===================");
                    System.out.println("Updated this " + s);
                    break;
                case 4:
                    if (s instanceof Manager) {
                        updateManagerCar((Manager) s);
                        System.out.println("===================");
                        System.out.println("Updated this " + s);

                    } else if (s instanceof Programmer) {
                        updateProject((Programmer) s);
                        System.out.println("===================");
                        System.out.println("Updated this " + s);

                    } else if (s instanceof Secretary) {
                        updateSecrataryTask((Secretary) s);
                        System.out.println("===================");
                        System.out.println("Updated this " + s);

                    } else if (s instanceof Janitor) {
                        updateJanitorTools((Janitor) s);
                        System.out.println("===================");
                        System.out.println("Updated this " + s);
                    }
                    break;

                case 5:
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
                    System.out.println("===================");
                    System.out.println("Updated this " + s);
                    break;

                default:
                    System.out.println("===================");
                    System.out.println("Wrong choice! Choose again!");
                    System.out.println("===================");

            }
        } else {
            System.out.println("NO EMPLOYEE WITH THIS ID!");
        }
    }

    public static void economyMenu() {

        boolean loop = true;
        while (loop) {
            System.out.println("===================");
            System.out.println("    ECONOMY MENU    ");
            System.out.println("===================");
            System.out.println("1. Total Company Salary");
            System.out.println("2. Total Managers Salary");
            System.out.println("3. Total Programmers Salary");
            System.out.println("4. Total Secretaries Salary");
            System.out.println("5. Total Janitors Salary");
            System.out.println("6. Total Company Bonus");
            System.out.println("7. Total Managers Bonus");
            System.out.println("8. Total Programmers Bonus");
            System.out.println("9. Total Secretaries Bonus");
            System.out.println("10. Total Janitors Bonus");
            System.out.println("11. Print All Employee Bonus");
            System.out.println("0. Main menu");
            System.out.println("===================");
            System.out.print("Make a choice: ");

            int choice = readIntNumber();

            switch (choice) {
                case 1:
                    System.out.println("===================");
                    totalCompanySalary();
                    break;

                case 2:
                    System.out.println("Total manager department salary: " + totalManagerSalary() + " kr.");
                    break;

                case 3:
                    System.out.println("Total programmer department salary: " + totalProgrammerSalary() + " kr.");
                    break;

                case 4:
                    System.out.println("Total secretary department salary: " + totalSecretarySalary() + " kr.");
                    break;

                case 5:
                    System.out.println("Total janitor department salary: " + totalJanitorSalary() + " kr.");
                    break;

                case 6:
                    System.out.println("===================");
                    totalCompanyBonus();
                    break;

                case 7:
                    System.out.println("====================");
                    managersBonus();
                    break;

                case 8:
                    System.out.println("====================");
                    programmersBonus();
                    break;

                case 9:
                    System.out.println("====================");
                    secretariesBonus();
                    break;

                case 10:
                    System.out.println("====================");
                    janitorsBonus();
                    break;

                case 11:
                    calculateBonus();
                    break;

                case 0:
                    loop = false;
                    break;

                default:
                    System.out.println("===================");
                    System.out.println("Wrong choice! Choose again!");
                    System.out.println("===================");

            }

        }

    }

    public static void staffStatisticsMenu() {

        boolean loop = true;
        while (loop) {
            System.out.println("====================");
            System.out.println(" STATISTICS MENU   ");
            System.out.println("====================");
            System.out.println("1. Average Salary.");
            System.out.println("2. Average Managers Salary");
            System.out.println("3. Average Programmers Salary");
            System.out.println("4. Averare Secretaries Salary");
            System.out.println("5. Average Janitors Salary");
            System.out.println("6. Highest Salary");
            System.out.println("7. Lowest Salary");
            System.out.println("0. Main menu");
            System.out.println("====================");
            System.out.print("Make a choice: ");
            int choice = readIntNumber();

            switch (choice) {

                case 1:
                    averageCompanySalary();
                    break;

                case 2:
                    System.out.println("====================");
                    averageManagerDepSalary();
                    break;

                case 3:
                    System.out.println("====================");
                    averageProgrammerDepSalary();
                    break;

                case 4:
                    System.out.println("====================");
                    averageSecretaryDepSalary();
                    break;

                case 5:
                    System.out.println("====================");
                    averageJanitorDepSalary();
                    break;

                case 6:
                    maxSalary();
                    break;

                case 7:
                    minimumSalary();
                    break;

                case 0:
                    loop = false;
                    break;

                default:
                    System.out.println("===================");
                    System.out.println("Wrong choice! Choose again!");
                    System.out.println("===================");
            }
        }
    }

    public static void sortStaffMenu() {
        boolean loop = true;

        while (loop) {
            System.out.println("===================");
            System.out.println("    SORT MENU      ");
            System.out.println("===================");
            System.out.println("1. Sort By Name - ascending order");
            System.out.println("2. Sort By Name - descending order");
            System.out.println("\n3. Sort By Age - ascending order");
            System.out.println("4. Sort By Age - descending order");
            System.out.println("\n5. Sort By Salary - ascending order");
            System.out.println("6. Sort By Salary - descending order");
            System.out.println("\n0. Main menu");
            System.out.println("===================");
            System.out.print("Make a choice: ");

            int choice = readIntNumber();

            switch (choice) {
                case 1:
                    myStaff.sort(sortByName);
                    printAllStaff();
                    break;

                case 2:
                    myStaff.sort(sortByNameD);
                    printAllStaff();
                    break;

                case 3:
                    myStaff.sort(sortByAge);
                    printAllStaff();
                    break;

                case 4:
                    myStaff.sort(sortByAgeD);
                    printAllStaff();
                    break;

                case 5:
                    myStaff.sort(sortBySalary);
                    printAllStaff();
                    break;

                case 6:
                    myStaff.sort(sortBySalaryD);
                    printAllStaff();
                    break;

                case 0:
                    loop = false;
                    break;

                default:
                    System.out.println("===================");
                    System.out.println("Wrong choice! Choose again!");
                    System.out.println("===================");
            }
        }
    }

}
