public class PartitionEqualSubsetSum416 {
    //TODO ChangA
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;

        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        if(sum % 2 == 1)
            return false;

        sum = sum / 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for(int x : nums){
            for(int i = sum; i >= x; i--)
                dp[i] = dp[i] || dp[i - x];
        }

        return dp[sum];


    }

}
