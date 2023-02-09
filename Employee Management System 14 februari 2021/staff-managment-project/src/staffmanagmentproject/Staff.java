package staffmanagmentproject;
// Abstract class/super class

public abstract class Staff {
// attributes
    static int idGenerator = 1;
    private final int id;
    private String name;
    private int age;
    private double salary;
    private final double bonusBase;

    public Staff(String name, int age, double salary) {
        this.id = idGenerator++;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.bonusBase = 2000;
    }

    public abstract double bonus();

    public abstract double salary();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonusBase() {
        return bonusBase;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }

}
