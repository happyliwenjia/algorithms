
public class zuichanggonggongzixulie {
    /**
     * 最长公共子序列
     *
     * 问题：
     *     给定两个序列X={x1,x2,...,xn} 和 Y={y1,y2,...,,yn}，找出X和Y的最长公共子序列。
     *
     * 测试输入：
     *     A B C B D A B
     *     B D C A B A
     * 测试输出：
     *     4
     *     BCBA
     */

    public static void main(String args[]){
        String[] x = {"A","B","C","B","D","A","B"};
        String[] y = {"B","D","C","A","B","A"};
        int[][] b = new int[x.length+1][y.length+1];
        int[][] c = lcsLength(x,y,b);
        System.out.println(c[x.length][y.length]);
        lcs(x.length,y.length,x,b);
        int n;
    }

    /**
     * 输入：x序列，y序列
     * 输出：b数组，返回数组c。
     * c[i][j]存储Xi和Yj的最长公共子序列的长度
     * b[i][j]记录c[i][j]的值是由哪一个子问题的解得到的，在构造最长公共子序列时要用到。
     * @return
     */
    public static int[][] lcsLength(String[] x,String[] y,int[][] b) {
        // 初始化数组c
        int[][] c = new int[x.length+1][y.length+1]; //0存空序列
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                c[i][j] = 0;
            }
        }
        // 开始规划
        for(int i=1;i<=x.length;i++){
            for(int j=1;j<=y.length;j++){
                if(x[i-1]==y[j-1]){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = 1;
                }else{
                    if(c[i-1][j]>=c[i][j-1]){
                        c[i][j] = c[i-1][j];
                        b[i][j] = 2;
                    }else{
                        c[i][j] = c[i][j-1];
                        b[i][j] = 3;
                    }
                }
            }
        }
        return c;
    }

    public static void lcs(int i,int j,String[]x,int[][]b){
        // 结束条件
        if(i==0 || j==0) return;

        // 判断b[i][j]进入不同分支
        if(b[i][j]==1){
            lcs(i-1,j-1,x,b);

        }else{
            if(b[i][j]==2) lcs(i-1,j,x,b);
            else lcs(i,j-1,x,b);
        }
    }
}