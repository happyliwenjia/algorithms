import java.util.ArrayList;
import java.util.Scanner;

public class SortAlgorithms {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String List=input.nextLine();
        String[] temp=List.split("\\s+");
        int[] array=new int[temp.length];
        for(int i=0;i<temp.length;i++){
            array[i]=Integer.valueOf(temp[i]);
        }
//        Print(bubbleSort(array));
       Print(QuickSort(array,0,array.length-1));
   //     Print(insertSort(array));
//        guibingSort(array,0,array.length-1);
      //  Print(array);
    }
    //冒泡排序,从小到大，两层循环
    public static int[] bubbleSort(int[] array)  {
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }
    //快速排序,回溯算法,先从后往前，再从前往后反复
    public static int[] QuickSort(int[] array,int low,int high){
        int start=low;
        int end=high;
        int key=array[low];
        int temp;
        while(end>start){
            while(end>start&&array[end]>=key){
                end--;
            }
            if(end>start&&array[end]<key){
                temp=array[end];
                array[end]=array[start];
                array[start]=temp;
            }
            while(end>start&&array[start]<=key){
                start++;
            }
            if(end>start&&array[start]>key)
            {
                temp=array[end];
                array[end]=array[start];
                array[start]=temp;
            }
        }
        if(low<start){
            QuickSort(array,low,start-1);
        }
        if(high>end){
            QuickSort(array,end+1,high);
        }
        return array;
    }
    //打印数组
    public static void Print(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    //插入排序  本身就是排好序的序列，再加入一个元素从小到大，从前往后查找,本例中假设给一个完全为空的
    public static int[] insertSort(int[] array){
     for(int i=1;i<array.length;i++){
         //定义插入的数
         int insertval=array[i];
         //定义被插入的位置,因为只有i-1个数被排好序
         int index=i-1;
         while(index>=0&&insertval<array[index]){
             array[index+1]=array[index];
             index--;
         }
         array[index+1]=insertval;
         }
        return array;
     }
//希尔排序 定一个起始间隔值，每次N=N/3+1去缩小，先是间隔N个取值去直接插入排序，之后每次间隔N个排序
    //归并排序  先将原始数据分散成多个2个小序列（递归），再合并2个有序数组
    public static void guibingSort(int[] array,int low,int high){
        if(low>=high){
            return ;
        }
        int mid=(low+high)/2;
        guibingSort(array,low,mid);
        guibingSort(array,mid+1,high);
        merge(array,low,mid,high);
    }
    //合并2个有序小数组为一个有序大数组
    public static void merge(int[] array,int low,int mid,int high){
        int left1=low;
        int left2=mid+1;
        int[] str=new int[high-low+1];
        int i=0;
        while(left1<=mid&&left2<=high){
            if(array[left1]<=array[left2]){
                str[i]=array[left1];
                left1++;
                i++;
            }else{
                str[i]=array[left2];
                left2++;
                i++;
            }
        }
        while(left1<=mid){
            str[i]=array[left1];
            i++;
            left1++;
        }
        while(left2<=high){
            str[i]=array[left2];
            i++;
            left2++;
        }
       for(int j=0;j< str.length;j++){
           array[j+low]=str[j];
       }
    }
    //桶排序 先找出最大值和最小值去放入桶中 然后进行分桶 ，排好序在合并
    //基数排序 按照位数，位数不够的需要先补齐。先拍个位再拍十位 再拍百位
    }
