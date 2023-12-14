public class TestPolygon {
    TestPolygon(){}
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-1.5, 1.5);
        Point p3 = new Point(1.5, 1.5);
        Point[] point1 = new Point[3];
        point1[0] = p1;
        point1[1] = p2;
        point1[2] = p3;
        Polygon polygon1 = new Polygon(point1);
        System.out.println(polygon1.toString());
        p1 = new Point(-0.5, 0);
        p2 = new Point(0, 1);
        p3 = new Point(2, 1);
        Point p4 = new Point(2.5, 0);
        point1 = new Point[4];
        point1[0] = p1;
        point1[1] = p2;
        point1[2] = p3;
        point1[3] = p4;
        polygon1 = new Polygon(point1);
        System.out.println(polygon1.toString());
        p1 = new Point(-4.22, -0.82);
        p2 = new Point(-3.26, 2.24);
        p3 = new Point(-0.6, 4.02);
        p4 = new Point(2.8, 2.6);
        Point p5 = new Point(1.1, -1.68);
        point1 = new Point[5];
        point1[0] = p1;
        point1[1] = p2;
        point1[2] = p3;
        point1[3] = p4;
        point1[4] = p5;
        polygon1 = new Polygon(point1);
        System.out.println(polygon1.toString());
    }
}
