
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author:
 * @Email:
 * @Date: 2020/9/13
 * @Time: 19:43
 * @Version: 1.0
 * @Description: Description
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[][] edges=new int[2][2];
        edges[1][0]=99;
        edges[1][1]=2;
        edges[0][0]=6;
        edges[0][1]=6;
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=0;i<2;i++)
        System.out.println(edges[i][0]+" "+edges[i][1]);
    }

}


