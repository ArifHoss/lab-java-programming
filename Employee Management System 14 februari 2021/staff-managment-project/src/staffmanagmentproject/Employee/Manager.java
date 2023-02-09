package staffmanagmentproject.Employee;
// Subclass (inherit from Staff)

import staffmanagmentproject.Staff;

public class Manager extends Staff{
    
    private String typeOfCar;
    
    public Manager(String name, int age, double salary,String typeOfCar) {
        super(name, age, salary);
        this.typeOfCar = typeOfCar;
    }
     @Override
    public double bonus() {
        double mb = getBonusBase()+(getAge()*100);
        return mb;
    }
    @Override
    public double salary(){
    double mSalary = getSalary();
    return mSalary;
    }


    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }
    
    @Override
    public String toString(){
    return super.toString()+" Position: manager, Type of car: "+typeOfCar;
    }
   
}
