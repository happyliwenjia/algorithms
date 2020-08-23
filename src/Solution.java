class Solution {
    public static void main(String[] args){
        Solution demo=new Solution();
        int[] nums={1,1,1,2,2,2,3,3,3};
        System.out.print(demo.findNumberOfLIS(nums));
    }
    public int findNumberOfLIS(int[] nums) {
//动态规划问题，dp[i]以nums[i]结尾的最长递增序列，必须含有nums[i]
        if(nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        int[] count=new int[nums.length];
        dp[0]=1;
        count[0]=1;
        int max=1;
        int sum=0;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            count[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }else if(dp[j]+1==dp[i]){
                        count[i]++;
                    }
                }
            }
            if(dp[i]>max){
                max=dp[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(max==dp[i]){
                sum=sum+count[i];
            }
        }
        return sum;
    }
}