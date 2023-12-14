package com.s3;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("create a wallet:");
        Wallet XMU=new Wallet(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.print(XMU.toString()+" total: ￥"+XMU.balance()+"\n");

        int Num;
        System.out.println("存入请按1,取出请按2,终止服务请按0");
        int order;
        order=sc.nextInt();
        while(order!=0){
            if(order==1){
                Num=sc.nextInt();
                XMU.deposit(Num);
                System.out.println("deposit "+Num+" yuan:");
            }else if(order==2){
                Num= sc.nextInt();
                System.out.println("try to withdraw "+Num+" yuan:");

                int y=XMU.withdraw(Num);
                if(y==Num)
                    System.out.println("success to withdraw "+Num+" yuan!");
                else
                    System.out.println("can only withdraw "+y+" yuan!");
            }
            System.out.print(XMU.toString()+" total: ￥"+XMU.balance()+"\n");
            order=sc.nextInt();
        }
        System.out.println("不使用toString函数查看Wallet：");
        getDetail(XMU);
    }
    public static void getDetail(Wallet E){
        int[] value={0,0,0,0,0};
        int sum=0;

        //从小到大取
        int y=E.withdraw(1);
        while(y==1){
            value[0]++;
            sum+=y;
            y=E.withdraw(1);
        }
        y=E.withdraw(5);
        while(y==5){
            value[1]++;
            sum+=y;
            y=E.withdraw(5);
        }
        y=E.withdraw(10);
        while(y==10){
            value[2]++;
            sum+=y;
            y=E.withdraw(10);
        }
        y=E.withdraw(20);
        while(y==20){
            value[3]++;
            sum+=y;
            y=E.withdraw(20);
        }
        y=E.withdraw(100);
        while(y==100){
            value[4]++;
            sum+=y;
            y=E.withdraw(100);
        }

        System.out.println("balance: ￥1 * "+value[0]+",￥5 * "+value[1]+",￥10 * "+value[2]+",￥20 * "+value[3]+",￥100 * "+value[4]+" total: "+"￥"+sum);


        //将取出的重新放入
        while(value[0]!=0){
            E.deposit(1);
            value[0]--;
        }
        while(value[1]!=0){
            E.deposit(5);
            value[1]--;
        }
        while(value[2]!=0){
            E.deposit(10);
            value[2]--;
        }
        while(value[3]!=0){
            E.deposit(20);
            value[3]--;
        }
        while(value[4]!=0){
            E.deposit(100);
            value[4]--;
        }
    }
}
