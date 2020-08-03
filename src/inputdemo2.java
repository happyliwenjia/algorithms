import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class inputdemo2 {
    //输入一组数据 以，来分割，输出带有[]
//    输入数据为1，4，5  输出数据为[2，3，4]
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String f=input.nextLine();
        String[] e=f.split(",");
//        ArrayList<Integer> list=new ArrayList<>();
        List list=new ArrayList<>();
        for(int i=0;i<e.length;i++){
            //如果直接存入字符串，就可以没有尖括号[]
            list.add(e[i]);
//            list.add(Integer.valueOf(e[i]));
        }
//        System.out.print(list);
        for(int i=0;i<e.length;i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
