package com.s1;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point2D {
    private double px;
    private double py;

    Point2D belong;

    public Point2D(){

    }
    public Point2D(int px,int py){
        this.px=(double)px;//方法中的形参与成员变量同名，带this的为成员变量
        this.py=(double)py;
    }
    public void setX(double x){
        px=x;
    }
    public void setY(double y){
        py=y;
    }
    public void setBelong(Point2D a){
        belong=a;
    }
    //带参构造方法

    public double getX(){
        return px;
    }
    public double getY(){
        return py;
    }
    public Point2D getBelong(){
        return belong;
    }
    //计算p1,p2两点之间的距离
    public double distance(Point2D p1,Point2D p2){
        return sqrt(pow(p1.getX()- p2.getX(),2)+pow(p1.getY()-p2.getY(),2));
    }
}
