import java.util.Scanner;
//同样都是nextint就没有问题，如果是现有nextInt再有nextString会报错，先是nextString再是nextInt也没有问题
public class binarySearchAlgorithm {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int K=input.nextInt();
        int[] array=new int[K];
        for(int i=0;i<K;i++){
            array[i]=input.nextInt();
        }
        System.out.println(binarySearch(array,23));
    }
    public static int binarySearch(int[] array,int obj){
        int low=0;
        //java中的数组可以查看长度
        int high=array.length-1;
        int mid;
        while(low<=high){
            mid=(high-low)/2+low;
            if(array[mid]==obj){
                return mid;
            }else if(array[mid]<obj){
                low=mid+1;
            }else if(array[mid]>obj){
                high=mid-1;
            }
        }
        return -1;
    }
}
