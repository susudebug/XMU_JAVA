package com.s2;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(){
        year=0;
        month=0;
        day=0;
    }
    public MyDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public String toDateString(){
        return year+"年"+month+"月"+day+"日";
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
