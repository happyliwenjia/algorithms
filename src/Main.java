
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().trim().split(" ");
        int[] arr = new int[strs.length];
        for(int i = 0; i < strs.length; ++i) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(maxSumDivSeven((arr)));
    }
    public static int maxSumDivSeven(int[] arr) {
        int[][] dp = new int[arr.length + 1][7];
        dp[0][0]=0;
        for (int i = 1; i <7 ; i++) {
            dp[0][i]=Integer.MIN_VALUE;
        }
        for(int i = 1; i <= arr.length; ++i) {
            if(0 == arr[i - 1] % 7) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][0] + arr[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] + arr[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][2] + arr[i - 1]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][3] + arr[i - 1]);
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][4] + arr[i - 1]);
                dp[i][5] = Math.max(dp[i - 1][5], dp[i - 1][5] + arr[i - 1]);
                dp[i][6] = Math.max(dp[i - 1][6], dp[i - 1][6] + arr[i - 1]);
            } else if(1 == arr[i - 1] % 7) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][6] + arr[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + arr[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + arr[i - 1]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + arr[i - 1]);
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + arr[i - 1]);
                dp[i][5] = Math.max(dp[i - 1][5], dp[i - 1][4] + arr[i - 1]);
                dp[i][6] = Math.max(dp[i - 1][6], dp[i - 1][5] + arr[i - 1]);
            } else if(2 == arr[i - 1] % 7) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][5] + arr[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][6] + arr[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + arr[i - 1]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][1] + arr[i - 1]);
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][2] + arr[i - 1]);
                dp[i][5] = Math.max(dp[i - 1][5], dp[i - 1][3] + arr[i - 1]);
                dp[i][6] = Math.max(dp[i - 1][6], dp[i - 1][4] + arr[i - 1]);
            } else if(3 == arr[i - 1] % 7) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][4] + arr[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][5] + arr[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][6] + arr[i - 1]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][0] + arr[i - 1]);
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][1] + arr[i - 1]);
                dp[i][5] = Math.max(dp[i - 1][5], dp[i - 1][2] + arr[i - 1]);
                dp[i][6] = Math.max(dp[i - 1][6], dp[i - 1][3] + arr[i - 1]);
            } else if(4 == arr[i - 1] % 7) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][3] + arr[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][4] + arr[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][5] + arr[i - 1]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][6] + arr[i - 1]);
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][0] + arr[i - 1]);
                dp[i][5] = Math.max(dp[i - 1][5], dp[i - 1][1] + arr[i - 1]);
                dp[i][6] = Math.max(dp[i - 1][6], dp[i - 1][2] + arr[i - 1]);
            } else if(5 == arr[i - 1] % 7) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + arr[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3] + arr[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][4] + arr[i - 1]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][5] + arr[i - 1]);
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][6] + arr[i - 1]);
                dp[i][5] = Math.max(dp[i - 1][5], dp[i - 1][0] + arr[i - 1]);
                dp[i][6] = Math.max(dp[i - 1][6], dp[i - 1][1] + arr[i - 1]);
            } else if(6 == arr[i - 1] % 7) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + arr[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3] + arr[i - 1]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][4] + arr[i - 1]);
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][5] + arr[i - 1]);
                dp[i][5] = Math.max(dp[i - 1][5], dp[i - 1][6] + arr[i - 1]);
                dp[i][6] = Math.max(dp[i - 1][6], dp[i - 1][0] + arr[i - 1]);
            }
        }
        return dp[arr.length][0];
    }
}