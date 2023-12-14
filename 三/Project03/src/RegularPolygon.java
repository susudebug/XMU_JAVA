import java.text.DecimalFormat;

public class RegularPolygon extends Polygon{
    double sideLength;
    int sideNum;
    RegularPolygon(double sideLength, int sideNum) {
        super(new Point[sideNum]);
        this.sideLength = sideLength;
        this.sideNum = sideNum;
    }

    public double getSideLength() {
        return sideLength;
    }
    public int getSideNum() {
        return sideNum;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public void setSideNum(int sideNum) {
        this.sideNum = sideNum;
    }
    public double getArea() {
        double res = this.sideNum * 1.0 * this.sideLength * this.sideLength * Math.sin(2 * Math.PI / this.sideNum) /
                (4 * (1 - Math.cos(2 * Math.PI / this.sideNum)));
        return res;
    }
    public double getPerimeter() {
        double res = this.sideNum * this.sideLength * 1.0;
        return res;
    }
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(6);
        return "Area: " + df.format(this.getArea()) +
                " Perimeter: " + df.format(this.getPerimeter()) +
                " SideNum: " + this.sideNum;
    }
}
