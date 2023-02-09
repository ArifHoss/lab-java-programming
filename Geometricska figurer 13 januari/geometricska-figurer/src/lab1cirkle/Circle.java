package lab1cirkle;

public class Circle {

    private final double PI = 3.14;
    private double radie;

    public Circle(double radie) {
        this.radie = radie;
    }

    public double getRadie() {
        return radie;
    }

    public void setRadie(double radie) {
        this.radie = radie;
    }

    public double area() {
        return radie * radie * PI;
    }

    public double circumreference() {
        return PI * radie * 2;
    }

}
