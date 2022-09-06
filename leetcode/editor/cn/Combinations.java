//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1122 👎 0


package com.cute.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合
public class T77_Combinations{
    public static void main(String[] args) {
        Solution solution = new T77_Combinations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private  List<List<Integer>> ans;

        public List<List<Integer>> combine(int n, int k) {
            ans=new ArrayList<>();
            backtrace(1,n,k,new ArrayList<>());
            return ans;
        }
        private void backtrace(int start,int n,int k,List<Integer>tmp){
            if(tmp.size()==k){
                ans.add(new ArrayList<>(tmp));
                return;
            }
            for(int i=start;i<=n;i++){
                tmp.add(i);
                backtrace(i+1,n,k,tmp);
                tmp.remove(tmp.size()-1);
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
