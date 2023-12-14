package com.s4;

import java.util.Arrays;

public class Wallet {
    private int[] value=new int[5];//对应1,5,10,20,100
    private int[] w={1,5,10,20,100};
    private int[] c={5,2,2,5};
    //默认构造方法
    public Wallet(){
        Arrays.fill(value,0);
    }

    public Wallet(int x, int y, int z, int w, int k){
        value[0]=x;
        value[1]=y;
        value[2]=z;
        value[3]=w;
        value[4]=k;

    }
    //存钱
    public void deposit(int facevalue){
        switch (facevalue){
            case 1:{
                value[0]++;
                break;
            }
            case 5:{
                value[1]++;
                break;
            }
            case 10:{
                value[2]++;
                break;
            }
            case 20:{
                value[3]++;
                break;
            }
            case 100:{
                value[4]++;
                break;
            }
            default:break;
        }
    }
    //获取总余额
    public int balance(){
        return value[0]+value[1]*5+value[2]*10+value[3]*20+value[4]*100;
    }

    //取钱
    public int withdraw(int amount) {
        int[] value_temp=value.clone();
        int temp=amount,x;
        for(int i=4;i>=0;i--){
            x=temp/w[i];
            if(value_temp[i]>=x){
                temp-=x*w[i];
                value_temp[i]-=x;
            }
        }
        //用冗余的小钱替代大钱
        int[] use=value.clone();//每位用到的张数
        for(int i=4;i>=0;i--) {
            use[i] = value[i] - value_temp[i];
            if (i == 4)
                continue;
            //若高位有用到
            if (use[i + 1] != 0) {
                x = value_temp[i] / c[i];
                if (use[i + 1] >= x) {//若用到的比可替代的多
                    value_temp[i + 1] += x;
                    value_temp[i] -= x*c[i];
                } else {
                    value_temp[i + 1] += use[i + 1];
                    value_temp[i] -= use[i]*c[i];
                }
                use[i] = value[i] - value_temp[i];
            } else continue;
        }
        value=value_temp;

        if(temp==0){
            return amount;
        }else{
            x=amount-temp;
            return x;
        }
    }

    //显示
    public String toString(){
        return "balance: ￥1 * "+value[0]+",￥5 * "+value[1]+",￥10 * "+value[2]+",￥20 * "+value[3]+",￥100 * "+value[4];
    }
}
