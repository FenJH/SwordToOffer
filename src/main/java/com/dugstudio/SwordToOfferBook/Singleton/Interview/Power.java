package com.dugstudio.SwordToOfferBook.Singleton.Interview;

/**
 * @Author JH
 * @CreateDate 18-6-2
 * @Description 数值的整数次方
 */
public class Power {
    public double Power(double base, int exponent) {
        if (base!=0&&exponent==0)return 1;
        if (base==0)return 0;
        if (base==1)return 1;
        double result;
        if (exponent<0){
            int  exponentAbs=-exponent;
            result=Power(base,exponentAbs>>1);
        }else{
            result=Power(base,exponent>>1);
        }

        result*=result;
        //奇数和偶数判断 为真就是奇数
        if (((int)exponent&1)==1){
            if (exponent<0)return 1/(result*base);
            return result*base;
        }else{
            if (exponent<0)return 1/result;
            return result;
        }
    }

    public static void main(String[] args) {
        Power p=new Power();
        System.out.println(p.Power(3,-10));
        System.out.println(0.0000==0);
    }
}
