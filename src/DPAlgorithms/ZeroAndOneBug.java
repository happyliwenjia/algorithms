package DPAlgorithms;

import java.util.Scanner;

/*问题描述
给定一组n个物品，每种物品都有自己的重量（wi）和价值（vi），在限定的总重量C内，选择
若干个（每种物品可以选择0个或1个），使得物品价值最高
测试用例：
value:1 6 18 22 28
weight：1 2 5 6 7
n=5 C=11*/
public class ZeroAndOneBug {
    public static void main(String[] args){
/*        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int C=input.nextInt();
        int[] weight=new int[n+1];
        int[] value=new int[n+1];
        for(int i=1;i<n+1;i++){
            weight[i]=input.nextInt();
        }
        for(int i=1;i<n+1;i++){
            value[i]=input.nextInt();
        }*/
        int[] weight={0,1,2,5,6,7};
        int[] value={0,1,6,18,22,28};
        int n=5,C=11;
        ZeroAndOneBug demo=new ZeroAndOneBug();
        int[][] Price=demo.price(weight,value,C,n);
        System.out.println(Price[n][C]);
        demo.Printmessage(Price,weight,n,C);
        int[] desc=demo.DescPrice(weight,value,C,n);
        System.out.println(desc[desc.length-1]);
    }
    //得到最高的物品价值
    public int[][] price(int[] weight,int[] value,int C,int n){
        int[][] Price=new int[n+1][C+1];
       for(int i=0;i<n+1;i++){
           Price[i][0]=0;
       }
       for(int j=0;j<C+1;j++){
           Price[0][j]=0;
       }
       for(int i=1;i<n+1;i++){
           for(int j=1;j<C+1;j++){
               if(weight[i]>j){
                   Price[i][j]=Price[i-1][j];
               }else{
                   Price[i][j]=Math.max(Price[i-1][j],Price[i-1][j-weight[i]]+value[i]);
               }
           }
       }
       return Price;
    }
    //得到具体的选择了那些物品；
    public void Printmessage(int[][] Price,int[] weight,int n,int C){
        boolean[] isExist=new boolean[n+1];
        for(int i=n;i>0;i--){
                if(Price[i][C]==Price[i-1][C]){
                    isExist[i]=false;
                }else{
                    isExist[i]=true;
                    C=C-weight[i];
                }
        }
        for(int i=1;i<n+1;i++){
            if(isExist[i]){
                System.out.print(i+" ");
            }
        }
    }
    /*
    降维运算，把二维函数降为一维，还是二重循环，因为其实每次用的都是i-1行数据，并没有
    用到其他行，而且二层循环时必须从后往前循环，因为从前往后上一次的p[i-1][w]会被
    覆盖成p[i][w],取得值就不对了,一维数组不断从i-1行更新为i行的事情
    */
    public int[] DescPrice(int[] weight,int[] value,int C,int n){
        int[] descprice=new int[C+1];
        for(int j=0;j<C+1;j++){
            descprice[j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=C;j>=0;j--){
                if(weight[i]>j){
                    descprice[j]=descprice[j];
                }else{
                    descprice[j]=Math.max(descprice[j],value[i]+descprice[j-weight[i]]);
                }
            }
        }
        return descprice;
    }
}
