//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 921 👎 0


package com.cute.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
public class T90_SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new T90_SubsetsIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans;


        public List<List<Integer>> subsetsWithDup(int[] nums) {

            ans=new ArrayList<>();
            Arrays.sort(nums);
            backtrace(0,nums,new ArrayList<>());
            return ans;
        }
        private void backtrace(int start,int[]nums,List<Integer>tmp){
            ans.add(new ArrayList<>(tmp));
            for (int i=start;i<nums.length;i++){
                if(i!=start && nums[i]==nums[i-1]){
                    continue;
                }
                tmp.add(nums[i]);
                backtrace(i+1,nums,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
