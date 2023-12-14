package com.s1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Time();
        int[] x=new int[10];
        int[] y=new int[10];
        randomPoint(x,y);
        for(int i=0;i<10;i++)
            System.out.println("x[i]:"+x[i]+" y[i]:"+y[i]);
        Kmeans(x,y);
    }
    public static void Time(){
        //创建一个Date对象
        Date date=new Date();

        //格式化时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh:mm");
        String time=formatter.format(date);
        System.out.println(time);

        String time2[]=time.split("[-:]");
        for(int i=0;i<time2.length;i++){//数组为.length，字符串为.length()
            System.out.println(time2[i]);
        }
    }
    public static void randomPoint(int[] x,int[] y){
        Scanner sc=new Scanner(System.in);
        int seed=sc.nextInt();
        Random rand=new Random(seed);
        double a,b;
        a= rand.nextDouble(10);
        b= rand.nextDouble(10);
        System.out.println("a="+a+" b="+b);

        for(int i=0;i<10;i++)
            x[i]= rand.nextInt(100);
        for(int i=0;i<10;i++)
            y[i]= rand.nextInt(100);
    }
    public static void Kmeans(int[] x,int[] y){
        //创建10个Poin2D对象
        Point2D[] Point=new Point2D[10];
        for(int i=0;i<10;i++){
            Point[i]=new Point2D(x[i],y[i]);
        }
//        for(int i=0;i<10;i++){
//            System.out.println(Point[i].getX()+" "+Point[i].getY());
//        }
        //用来计算距离的
        Point2D temp=new Point2D();

        //若聚两类
        Point2D c1=Point[0];
        Point2D c2=Point[1];
        while(true) {
            System.out.println("原始聚类中心为: x:" + c1.getX() + " y:" + c1.getY() + " x2:" + c2.getX() + " y2:" + c2.getY());
            int flag = 0;
            for (int i = 0; i < 10; i++) {//初始化
                double a, b;
                a = temp.distance(c1, Point[i]);
                b = temp.distance(c2, Point[i]);
                if (a < b) {
                    Point[i].setBelong(c1);
                } else {
                    Point[i].setBelong(c2);
                }
            }
//            for (int i = 0; i < 10; i++) {
//                System.out.println("点:[" + Point[i].getX() + "," + Point[i].getY() + "]的中心为[" + Point[i].belong.getX() + "," + Point[i].belong.getY() + "]");
//            }
            double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < 10; i++) {
                if (Point[i].getBelong() == c1) {
                    x1 += Point[i].getX();
                    y1 += Point[i].getY();
                    sum1++;
                } else {
                    x2 += Point[i].getX();
                    y2 += Point[i].getY();
                    sum2++;
                }
            }
            x1 /= (double) sum1;
            y1 /= (double) sum1;
            x2 /= (double) sum2;
            y2 /= (double) sum2;
            if (x1 != c1.getX() || y1 != c1.getY() || x2 != c2.getX() || y2 != c2.getY())
                flag = 1;

            c1.setX(x1);
            c1.setY(y1);
            c2.setX(x2);
            c2.setY(y2);

            if (flag == 0){
                System.out.println("聚类中心未更新");
                break;
        }
            else
                System.out.println("更新后聚类中心为: x:" + c1.getX() + " y:" + c1.getY() + " x2:" + c2.getX() + " y2:" + c2.getY());
        }
        System.out.println("最终聚类中心为: x:"+c1.getX()+" y:"+c1.getY()+" x2:"+c2.getX()+" y2:"+c2.getY());
//        for(int i=0;i<10;i++){
//                System.out.println("点:["+Point[i].getX()+","+Point[i].getY()+"]的中心为["+Point[i].belong.getX()+","+Point[i].belong.getY()+"]");
//        }
    }
}
