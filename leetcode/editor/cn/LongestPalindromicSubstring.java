//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5537 👎 0

package com.cute.leetcode.editor.cn;
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {

        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int max=1,start=0;
        for(int j=0;j<n;j++){
            for(int i=0;i<=j;i++){
                if(j-i<2){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }else {
                    dp[i][j]=(dp[i+1][j-1] && s.charAt(i)==s.charAt(j));
                }
                if(dp[i][j]==true && max<j-i+1){
                    max=j-i+1;
                    start=i;
                }
            }
        }
        return  s.substring(start,start+max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}