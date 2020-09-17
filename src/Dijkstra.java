import java.util.Arrays;
import java.util.Scanner;

//Dijkstra求一个节点到其余所有节点的最短路径
//graph数组为每2个节点之间的直接距离，dist数组为初始点到所有点的最小距离
//st为是不是已经确定了这个点的距离
public class Dijkstra {
    static int INF=0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String a=input.nextLine();
        if(a==null||a.length()==0){
            System.out.println(0);
            return;
        }
        String[] b=a.trim().split("\\s+");
        int n=Integer.parseInt(b[0]);
        int m=Integer.parseInt(b[1]);
        int[][] graph=new int[n+1][n+1];
        int[] dist=new int[n+1];
        boolean[] st=new boolean[n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(graph[i],INF);
        }
        for(int i=0;i<m;i++){
            String s=input.nextLine();
            String[] str=s.trim().split("\\s+");
            int p=Integer.parseInt(str[0]);
            int w=Integer.parseInt(str[1]);
            int t=Integer.parseInt(str[2]);
            graph[p][w]=Math.min(t,graph[p][w]);
        }
        System.out.println(dijkstra(graph,dist,st,n));
    }
    public static int dijkstra(int[][] graph,int[] dist,boolean[] st,int n){
        Arrays.fill(dist,INF);
        dist[1]=0;
        //每次循环确定一个点的最短路径，同时更新st数组
        for(int i=0;i<n;i++){
            int t=-1;
            for(int j=1;j<=n;j++){
                if(!st[j]&&(t==-1||dist[t]>dist[j])){
                    t=j;
                }
            }

                st[t]=true;

            for(int j=1;j<=n;j++){
                dist[j]=Math.min(dist[j],dist[t]+graph[t][j]);
            }
        }
        if(dist[n]==INF){
            return -1;
        }
        return dist[n];
    }
}
