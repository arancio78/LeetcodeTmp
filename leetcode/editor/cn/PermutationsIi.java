//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1182 👎 0


package com.cute.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列 II
public class T47_PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new T47_PermutationsIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> ans;
        private boolean[]used;
        public List<List<Integer>> permuteUnique(int[] nums) {
            ans=new ArrayList<>();
            Arrays.sort(nums);
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
                if(used[i] || (i>0 &&nums[i]==nums[i-1] && !used[i-1])){
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
