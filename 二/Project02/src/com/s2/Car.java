package com.s2;

public class Car {
    private String carRenter;
    private int carNum;
    private String carName;
    private String carType;

    //每日金额
    private double rate;
    //组多少天
    private int days;
    //无参构造方法
    public Car(){
        carRenter="";
        carNum=0;
        carName="";
        carType="";
        rate=0;
        days=0;
    }
    //有参构造方法
    public Car(String carRenter,int carNum,String carName,String carType,double rate,int days){
        this.carRenter=carRenter;
        this.carNum=carNum;
        this.carName=carName;
        this.carType=carType;
        this.rate=rate;
        this.days=days;
    }
    public String getCarRenter(){
        return  carRenter;
    }
    public int getCarNum(){
        return carNum;
    }
    public String getCarName(){
        return carName;
    }
    public String getCarType(){
        return carType;
    }
    public double getRate(){
        return rate;
    }
    public int getDays(){
        return days;
    }
    public void setCarRenter(String carRenter){
        this.carRenter=carRenter;
    }
    public void setCarNum(int carNum){
        this.carNum = carNum;
    }
    public void setCarName(String carName){
        this.carName=carName;
    }
    public void setCarType(String carType){
        this.carType = carType;
    }
    public void setRate(double rate){
        this.rate=rate;
    }
    public void setDays(int days){
        this.days=days;
    }

    public String toString(){
        String s1="Car renter's name:"+carRenter+"\n"+"Car number:"+carNum+"\n"+"Car name:"+carName+"\n"+"Car type:"+carType+"\n"+"Rate:"+rate+"\n"+"Rented for:"+days+"days";
        return s1;
    }
}
