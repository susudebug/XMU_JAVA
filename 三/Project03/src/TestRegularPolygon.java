public class TestRegularPolygon {
    TestRegularPolygon(){}
    public static void main(String[] args) {
        RegularPolygon r1 = new RegularPolygon(3.1415926, 3);
        System.out.println(r1.toString());
        r1 = new RegularPolygon(3.1415926, 12);
        System.out.println(r1.toString());
        r1 = new RegularPolygon(3.1415926, 1000);
        System.out.println(r1.toString());
    }
}
