import java.util.Scanner;
//nextInt可以识别空格 但是不认识回车 输入空格就进入下个输入
public class inputdemo4 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
//        String a=input.nextLine();
//        int c=Integer.valueOf(a);
        int a =input.nextInt();
        int c =input.nextInt();
        String b=input.nextLine();
        System.out.print(a+","+b+c);
    }
}
