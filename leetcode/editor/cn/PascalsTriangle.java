//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 828 👎 0


package com.cute.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角
public class T118_PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new T118_PascalsTriangle().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer>tmp=new ArrayList<>();
            for(int j=0;j<i+1;j++){
                int v;
                if(j==0 || j==i){
                    v=1;
                }else {
                    v=ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                }
                tmp.add(v);
            }

            ans.add(tmp);

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
