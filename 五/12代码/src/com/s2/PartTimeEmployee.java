package com.s2;

public class PartTimeEmployee extends Employee{
    private int workHours;
    private int hourSalary;
    public PartTimeEmployee(){
        super();
        workHours=0;
        hourSalary=0;
    }
    public PartTimeEmployee(String name,String id,int year,int month,int day,int workHours,int hourSalary){
        super(name,id,year,month,day);
        this.hourSalary=hourSalary;
        this.workHours=workHours;
    }
    @Override
    public int getSalary(){
        //若本月为其生日
        if (birthday.getMonth()==6)
            return workHours*hourSalary+100;
        else
            return workHours*hourSalary;
    }

    @Override
    public String toString() {
        return super.toString()+"workHours:"+workHours+"\n"+"hourSalary:"+hourSalary+"\n"+"Salary:"+getSalary()+"\n";
    }
}
