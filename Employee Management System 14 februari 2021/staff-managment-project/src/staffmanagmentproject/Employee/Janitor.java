package staffmanagmentproject.Employee;
// Subclass (inherit from Staff)

import staffmanagmentproject.Staff;


public class Janitor extends Staff {

    private int numberOfTools;

    public Janitor(String name, int age, double salary, int numberOfTools) {
        super(name, age, salary);
        this.numberOfTools = numberOfTools;
    }

    @Override
    public double bonus() {
        double b = getBonusBase() * 2;

        return b;
    }

    @Override
    public double salary() {
        double jSalary = getSalary();
        return jSalary;
    }

    public int getNumberOfTools() {
        return numberOfTools;
    }

    public void setNumberOfTools(int numberOfTools) {
        this.numberOfTools = numberOfTools;
    }

    @Override
    public String toString() {
        return super.toString() + " Position: janitor, Number of tools: " + numberOfTools;
    }

}
