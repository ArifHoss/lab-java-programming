package staffmanagmentproject;
// Subclass (inherit from Staff)

public class Secretary extends Staff {

    private String task;

    public Secretary(String name, int age, double salary,String task) {
        super(name, age, salary);
        this.task = task;
    }
        @Override
    public double bonus() {
        double sb = getBonusBase()+(getAge()*3);
        return sb;
    }
    
    @Override
    public double salary() {
        double sSalary  = getSalary();
        return sSalary;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return super.toString() + " Positon: secretary, Task: " + task;
    }


}
