package com.s2;

public class Tester {
    public static void main(String[] args) {
        FullTimeEmployee p1=new FullTimeEmployee("小明","1",2000,3,4,5000);
        FullTimeEmployee p2=new FullTimeEmployee("小红","2",2000,6,4,5000);

        PartTimeEmployee p3=new PartTimeEmployee("李华","3",2000,3,4,8,600);
        PartTimeEmployee p4=new PartTimeEmployee("张伟","3",2000,6,4,8,600);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
    }
}
