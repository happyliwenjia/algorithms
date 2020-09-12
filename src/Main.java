import java.util.Arrays;
import java.util.Scanner;

public class Main {


    static int[][][] dp=new int[1005][1005*2][2];

    static int[] head=new int[1005*2];
    static int cnt;
    static int[] a=new int[1005];
    static int n,k;
    class node{
        int v;
        int next;
        int w;
    }
    static node[] p=new node[1005*2];
    void addedge(int u,int v){
        node temp=new node();
        temp.v=v;
        p[++cnt]=temp;
        p[cnt].next=head[u];
        head[u]=cnt;
    }
    void init(){
        cnt=0;
        Arrays.fill(head,-1);
      //  Arrays.fill(dp,0);
    }
    void dfs(int x,int fa){
        for(int i=0;i<=k;i++){
            dp[x][i][0]=dp[x][i][1]=a[x];
        }
        for(int e=head[x];e!=-1;e=p[e].next){
            int son=p[e].v;
            if(son==fa) continue;
            dfs(son,x);
            for(int j=k;j>=0;j--){
                for(int s=1;s<=j;s++){
                    if(s>=2){
                        dp[x][j][0]=Math.max(dp[x][j][0],dp[x][j-s][0]+dp[son][s-2][0]);
                    }
                    dp[x][j][1]=Math.max(dp[x][j][1],dp[x][j-s][0]+dp[son][s-1][1]);
                    if(s>=2){
                        dp[x][j][1]=Math.max(dp[x][j][1],dp[x][j-s][1]+dp[son][s-2][0]);
                    }
                }
            }
        }
    }


    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        Main demo=new Main();
       demo.init();
       n=input.nextInt();
       k=input.nextInt();
        for(int i=1;i<=n;i++){
            a[i]=1;
        }
        int u,v;
        for(int i=1;i<n;i++){
            u=i;
            v=input.nextInt();
            demo.addedge(u,v);
            demo.addedge(v,u);
        }
        demo.dfs(1,0);
        System.out.println(Math.max(dp[1][k][0],dp[1][k][1]));


    }

}