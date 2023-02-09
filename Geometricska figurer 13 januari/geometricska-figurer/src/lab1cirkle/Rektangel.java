package lab1cirkle;

public class Rektangel {

    private double base;
    private double hight;

    public Rektangel(double base, double hight) {
        this.base = base;
        this.hight = hight;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double area() {
        return base * hight;
    }

    public double circumreference() {
        return base * 2 + hight * 2;
    }

}
