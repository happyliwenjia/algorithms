package DPAlgorithms;
/**
 * 最长公共子序列
 *
 * 问题：
 *     给定两个序列X={x1,x2,...,xn} 和 Y={y1,y2,...,,yn}，找出X和Y的最长公共子序列,
 *     排序顺序应该一致。
 *
 * 测试输入：
 *     A B C B D A B
 *     B D C A B A
 * 测试输出：
 *     4
 *     BCBA
 *     */


public class LongestCommonSubsequence {
    public static void main(String[] args){
        LongestCommonSubsequence demo=new LongestCommonSubsequence();
        char[] x={'A','B','C','B','D','A','B'};
        char[] y={'B','D','C','A','B','A'};
        int[][] b=new int[x.length+1][y.length+1];
        System.out.println(demo.lcslength(x,y,b));
        demo.lcs(b,x,x.length, y.length);
    }
    //定义一个求最长公共子序列长度
    public int lcslength(char[] x,char[] y,int[][] b){
        int[][] dp=new int[x.length+1][y.length+1];
        for(int i=0;i< y.length+1;i++){
            dp[0][i]=0;
        }
        for(int i=0;i< x.length+1;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=x.length;i++){
            for(int j=1;j<=y.length;j++){
                if(x[i-1]==y[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    b[i][j]=1;
                }else if(dp[i-1][j]>=dp[i][j-1]){
                    dp[i][j]=dp[i-1][j];
                    b[i][j]=2;
                }else{
                    dp[i][j]=dp[i][j-1];
                    b[i][j]=3;
                }
            }
        }
        return dp[x.length][y.length];
    }
    //求公共子序列的路径
    public void lcs(int[][] b,char[] x,int i,int j){
        if(i==0||j==0){
            return;
        }
        if(b[i][j]==1){
            lcs(b,x,i-1,j-1);
            System.out.print(x[i-1]+" ");
        }else if(b[i][j]==2)
            lcs(b,x,i-1,j);
        else lcs(b,x,i,j-1);
    }
}
