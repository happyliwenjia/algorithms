import java.util.ArrayList;
import java.util.Scanner;
//实例：输入数据
//45
//56
//67
//d（非数字）
//输出 45 56 67
public class inputdemo5 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        ArrayList<String> list=new ArrayList<>();
        int length=0;
        //input.hasNextInt只是判断有没有下个int值
        while(input.hasNextInt()){
            list.add(input.nextLine());
            length++;
        }
        for(int i=0;i<length;i++){
            System.out.print(list.get(i)+" ");

        }
    }
}
