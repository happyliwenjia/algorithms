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
           System.out.print(Integer.valueOf(f[i]));
           if(i!=f.length-1){
               System.out.print(",");
           }
       }
    }
}
