//不用+-乘除，求2个数的加法
public class jiafa {
    public static int Add(int num1,int num2) {
        while (num2!=0) {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;
    }
    public static void main(String[] args){
        int a=881;
        int b=14;
        System.out.print(Add(a,b));
    }
}