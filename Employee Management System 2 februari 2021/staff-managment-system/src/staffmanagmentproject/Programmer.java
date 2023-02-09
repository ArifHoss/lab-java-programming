package staffmanagmentproject;
// Subclass (inherit from Staff)

public class Programmer extends Staff {

    private int numberOfProject;

    public Programmer(String name, int age, double salary, int numberOfProject) {
        super(name, age, salary);
        this.numberOfProject = numberOfProject;
    }
      @Override
    public double bonus() {
        double pb = getBonusBase()+(getNumberOfProject()*50);
        return pb;
    }
    public double salary(){
    double pSalary = getSalary();
    return pSalary;
    }


    public int getNumberOfProject() {
        return numberOfProject;
    }

    public void setNumberOfProject(int numberOfProject) {
        this.numberOfProject = numberOfProject;
    }

    public String toString() {
        return super.toString() + " Position: programmer, Number of projects: " + numberOfProject;
    }

  
}
