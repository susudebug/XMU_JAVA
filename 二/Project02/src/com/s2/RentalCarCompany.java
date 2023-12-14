package com.s2;

import java.util.Scanner;

public class RentalCarCompany {
    //存放出租的车的对象
    private Car[] theCars;
    //公司的名字
    private String name;

    //总天数
    private int totalDays;

    //总单日租金
    private double totalRate;

    //多少车已租出
    private int rentCnt;

    //无参构造
    public RentalCarCompany(){
        theCars=new Car[100];
        totalDays=0;
        totalRate=0;
        rentCnt=0;
    }
    //利用有参构造Company的名字
    public RentalCarCompany(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }


    //这些车将获得的受益--Car[]数组中所有受益的和
    public double getTotalSales(){
        double sum=0;
        for(int i=0;i<rentCnt;i++){
            sum+=theCars[i].getRate()*(double)theCars[i].getDays();
        }
        return sum;
    }
    //平均租赁时长
    public double getAvgDays(){
        return  (double)totalDays/(double)rentCnt;
    }
    //平均租金
    public double getAvgRate(){
        return  (double)totalRate/(double)rentCnt;
    }

    //查找有没有对应车号的相应车的租赁信息
    public void findReservation(int Num){
        int flag=0;
        for(int i=0;i<rentCnt;i++){
            if(Num==theCars[i].getCarNum()){
                System.out.println(theCars[i].toString());
                flag=1;
                break;
            }
        }
        if(flag==0)
            System.out.println("Could not find reservation for this car number "+Num);
    }
    //录入信息
    public void addReservation(){
        theCars[rentCnt]=new Car();
        Scanner sc=new Scanner(System.in);

        String renter;
        System.out.print("Car renter's name:");
        renter=sc.nextLine();
        theCars[rentCnt].setCarRenter(renter);

        int Num;
        System.out.print("Car number:");
        Num=sc.nextInt();
        theCars[rentCnt].setCarNum(Num);

        String Name;
        Name=sc.nextLine();//接受int类型的多余换行符
        System.out.print("Car name:");
        Name=sc.nextLine();
        theCars[rentCnt].setCarName(Name);

        String Type;
        System.out.print("Car type:");
        Type=sc.nextLine();
        theCars[rentCnt].setCarType(Type);
        //每日金额
        double rate;
        System.out.print("Rate: ￥");
        rate=sc.nextDouble();
        theCars[rentCnt].setRate(rate);
        //组多少天
        int days;
        System.out.print("Rented for:");
        days=sc.nextInt();
        theCars[rentCnt].setDays(days);

        totalRate+=theCars[rentCnt].getRate();
        totalDays+=theCars[rentCnt].getDays();
        rentCnt++;
    }

}
