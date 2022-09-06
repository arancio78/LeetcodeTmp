//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1101 👎 0


package com.cute.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和 II
public class T40_CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new T40_CombinationSumIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private  List<List<Integer>> ans;
        private int target;
        private int[] cand;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            ans=new ArrayList<>();
            Arrays.sort(candidates);
            this.target=target;
            this.cand=candidates;

            backtrace(0,0,new ArrayList<>());
            return ans;
        }
        private void backtrace(int sum,int start,List<Integer>tmp){
            if(sum==target){
                ans.add(new ArrayList<>(tmp));
                return;
            }
            if (sum>target){
                return;
            }
            for (int i=start;i<cand.length;i++){
                if(i>start && cand[i]==cand[i-1]){
                    continue;
                }
                int c=cand[i];
                tmp.add(c);
                backtrace(sum+c,i+1,tmp);
                tmp.remove(tmp.size()-1);
            }
        }





    }
//leetcode submit region end(Prohibit modification and deletion)

}
