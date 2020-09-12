
import java.util.ArrayList;
import java.util.Scanner;
public class inputdemo1 {
    //输入一组数据 以空格为输入，输出为加逗号的格式如1 2 3 输出1，2，3
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String e = sc.nextLine();
        //以空格为分隔符
        String[] f = e.split("\\s+");
        for(int i=0;i<f.length;i++){
            System.out.print(Integer.parseInt(f[i]));
            if(i!=f.length-1){
                System.out.print(",");
            }
        }
    }
    //求最小公倍数
    public static int multiple(int x,int y){
        int z ;
        for(z=x;;z++){
            if(z%x==0&&z%y==0){
                return z;
            }
        }
    }
    //求最大公约数
    public static int  method(int x,int y){
        int a,b,c;
        a=x;b=y;
        /* 余数不为0，继续相除，直到余数为0 */
        while(b!=0){
            c=a%b;
            a=b;
            b=c;
        }
        return a ;
    }
    //严格的写string字符串转换为int类型，如果转换 超过int的范围需要抛出异常
    public void StringToInt(String s){
        try{
            int a=Integer.parseInt(s);
            System.out.print(a);
        }catch (Exception e){
            if(s.charAt(0)=='-'){
                //输出integer最小值
                System.out.print(Integer.MIN_VALUE);
            }else{
                //输出integer最大值
                System.out.print(Integer.MAX_VALUE);
            }
        }
    }
    //字符串反转函数
    public static String reverse1(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}