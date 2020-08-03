
public class Solution {

  public static void main(String[] args){


    String s=Integer.toBinaryString(1);
    String[] split=s.split("");
    int a=0;
    for(int i = 0; i < split.length; i++) {
      if (split[i].equals("1"))
      {
        a++;
      }
    }
    System.out.println(a);
    String l=Integer.toBinaryString(1);
    String[] arr=l.split("");
    int count=0;
    for(int i=0;i<arr.length;i++){
      if(arr[i].equals("1")){
        count++;
      }
    }
    System.out.println(count);
  }
}