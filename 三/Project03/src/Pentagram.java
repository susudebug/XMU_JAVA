import java.text.DecimalFormat;

public class Pentagram extends Polygon{
    double sideLength;
    Pentagram(double sideLength) {
        super(new Point[10]);
        this.sideLength = sideLength;
    }
    public double getArea() {
        double res = 5 * this.sideLength * this.sideLength / (1.0 / Math.tan(Math.PI / 5.0) + 1.0 / Math.tan(Math.PI / 10.0));
        return res;
    }
    public double getPerimeter() {
        double res = 10 * this.sideLength;
        return res;
    }
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(6);
        return "Area: " + df.format(this.getArea()) +
                " Perimeter: " + df.format(this.getPerimeter()) +
                " SideNum: 10";
    }
}
