//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 1496 👎 0


package com.cute.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：N 皇后
public class T51_NQueens{
    public static void main(String[] args) {
        Solution solution = new T51_NQueens().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>res=new ArrayList<>();
        String[][]board=new String[n][n];
        for(int i=0;i<n;i++){
            String[]tmp=new String[n];
            Arrays.fill(tmp,".");
            board[i]=tmp;
        }
        boolean[]col=new boolean[n];
        boolean[]slash=new boolean[2*n];
        boolean[]backslash=new boolean[2*n];


        backtrace(0,n,col,slash,backslash,board,res);

        return res;
    }
 private void backtrace(int index,int n,boolean[]col,boolean[] slash,boolean[]backslash,String[][]board,List<List<String>>res){
      if(index==n){
          List<String> tmp=new ArrayList<>();
          for (String[] strings:board){
              tmp.add(String.join("",strings));
          }
          res.add(tmp);
          return;
      }
      for (int i=0;i<n;i++){
          if(!col[i] && !slash[index+i] && !backslash[n-index+i]){
              board[index][i]="Q";
              col[i]=true;
              slash[index+i]=true;
              backslash[n-index+i]=true;
              backtrace(index+1,n,col,slash,backslash,board,res);
              board[index][i]=".";
              col[i]=false;
              slash[index+i]=false;
              backslash[n-index+i]=false;
          }
      }
 }


}
//leetcode submit region end(Prohibit modification and deletion)

}
