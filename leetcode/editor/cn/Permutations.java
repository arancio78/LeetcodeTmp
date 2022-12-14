//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2208 👎 0


package com.cute.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：全排列
public class T46_Permutations{
    public static void main(String[] args) {
        Solution solution = new T46_Permutations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> ans;
        private boolean[]used;
        public List<List<Integer>> permute(int[] nums) {
            ans=new ArrayList<>();
            int n=nums.length;
            used=new boolean[n];
            backtrace(0,n,nums,new ArrayList<>());

            return ans;
        }
        private void backtrace(int start,int n,int[]nums,List<Integer>tmp){

            if(start==n){
                ans.add(new ArrayList<>(tmp));
                return;
            }
            for (int i=0;i<n;i++){
                if(used[i]){
                    continue;
                }
                tmp.add(nums[i]);
                used[i]=true;
                backtrace(start+1,n,nums,tmp);
                used[i]=false;
                tmp.remove(tmp.size()-1);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
