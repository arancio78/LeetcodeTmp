//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1473 👎 0


package com.cute.leetcode.editor.cn;
//Java：分割等和子集
public class T416_PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new T416_PartitionEqualSubsetSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int s:nums){
            sum+=s;
        }
        if(sum%2!=0){
            return false;
        }

        int m=nums.length;
        int n=sum/2;

        int[][]dp=new int[m+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=dp[i-1][j];
                if (j-nums[i-1]>=0){
                    dp[i][j]+=dp[i-1][j-nums[i-1]];
                }
            }
        }
        return (dp[m][n]!=0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
