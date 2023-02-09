package lab1cirkle;

public class Triangel {

    private double base;
    private double hight;
    private double side1;
    private double side2;

    public Triangel(double base, double hight, double side1, double side2) {
        this.base = base;
        this.hight = hight;
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double area() {
        return base * hight / 2;

    }

    public double circumreference() {
        return base + side1 + side2;
    }

}
