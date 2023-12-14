package com.s2;
//定义一个抽象类
public abstract class Employee {
    protected String name;
    protected String id;
    protected MyDate birthday;
    public Employee(){
        name="null";
        id="null";
        birthday=new MyDate(0,0,0);
    }
    public Employee(String name,String id,int year,int month,int day){
        this.name=name;
        this.id=id;
        birthday=new MyDate(year,month,day);
    }
    //抽象方法
    public abstract int getSalary();

    public String toString(){
        return"name："+name+"\n"+"id:"+id+"\n"+"birthday:"+birthday.toDateString()+"\n";
    }
}
