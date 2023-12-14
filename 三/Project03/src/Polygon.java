import java.text.DecimalFormat;

public class Polygon {
    private Point[] points;
    public Polygon(Point[] points) {
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            this.points[i] = points[i];
        }
    }
    public double getArea() {
        double res = 0;
        for (int i = 0; i < this.points.length - 1; i++) {
            res += (this.points[i].x * this.points[i + 1].y - this.points[i + 1].x * this.points[i].y) / 2.0;
        }
        res += (this.points[this.points.length - 1].x * this.points[0].y - this.points[0].x * this.points[this.points.length - 1].y) / 2.0;
        return Math.abs(res);
    }
    public double getPerimeter() {
        double res = 0;
        for (int i = 0; i < this.points.length - 1; i++) {
            res += Math.abs(Math.sqrt((this.points[i].x - this.points[i + 1].x) * (this.points[i].x - this.points[i + 1].x) + (this.points[i].y - this.points[i + 1].y) * (this.points[i].y - this.points[i + 1].y)));
        }
        res += Math.abs(Math.sqrt((this.points[this.points.length - 1].x - this.points[0].x) * (this.points[this.points.length - 1].x - this.points[0].x) + (this.points[this.points.length - 1].y - this.points[0].y) * (this.points[this.points.length - 1].y - this.points[0].y)));
        return res;
    }
    public int getSideNum() {
        return this.points.length;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(6);
        return "Area: " + df.format(this.getArea()) +
                " Perimeter: " + df.format(this.getPerimeter()) +
                " SideNum: " + this.getSideNum();
    }
}
