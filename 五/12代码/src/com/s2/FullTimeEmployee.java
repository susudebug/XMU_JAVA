package com.s2;

import javax.print.DocFlavor;

public class FullTimeEmployee extends Employee{
    private int salary;

    public FullTimeEmployee(){
        super();
        salary=0;
    }
    public FullTimeEmployee(String name,String id,int year,int month,int day,int salary){
        super(name,id,year,month,day);
        this.salary=salary;
    }

    @Override
    public int getSalary() {
        //若本月为其生日
        if (birthday.getMonth()==6)
            return salary+100;
        else
            return salary;
    }
    public String toString(){
        return super.toString()+"salary:"+getSalary()+"\n";
    }
}
