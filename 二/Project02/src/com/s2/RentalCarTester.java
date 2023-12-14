package com.s2;

import java.util.Scanner;

public class RentalCarTester {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        RentalCarCompany XMU=new RentalCarCompany();

        System.out.print("Rental Car Company:");
        String CName=sc.nextLine();
        XMU.setName(CName);

        //录入车辆
        for(int i=0;i<4;i++){
            XMU.addReservation();
        }


        //查找对应租赁信息
        System.out.print("Found reservation for car number：");
        int Num= sc.nextInt();
        XMU.findReservation(Num);

        System.out.println("Average days rented out is :"+XMU.getAvgDays());
        System.out.println("Average rate is: ￥"+XMU.getAvgRate());
        System.out.println("Total rental income is: ￥"+XMU.getTotalSales());

        System.out.print("Found reservation for car number：");
        Num= sc.nextInt();
        XMU.findReservation(Num);
    }
}
