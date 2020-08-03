import java.util.ArrayList;
import java.util.Scanner;

public class inputdemo3 {
//    例输入数据为
//    4
//    1 3 5
//    3 5 6
//    3 4 5
//    1 2 3
//    输出数据为
//    1,3,5
//    3,5,6
//    3,4,5
//    1，2，3
    public static void main(String[] args){
    Scanner input=new Scanner(System.in);
    String first=input.nextLine();
    int K=Integer.valueOf(first);
    ArrayList<String> number =new ArrayList<>();
    String temp=new String();
    for(int i=0;i<K;i++){
        number.add(input.nextLine());
    }
        for(int i=0;i<K;i++){
            temp=number.get(i);
            String[] a=temp.split("\\s+");
            for(int j=0;j<a.length;j++){
                System.out.print(a[j]);
                if(j!=a.length-1){
                    System.out.print(",");
                }else{
                    System.out.println();
                }
            }
        }

    }
}
