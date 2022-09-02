//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 796 👎 0


package com.cute.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：俄罗斯套娃信封问题
public class T354_RussianDollEnvelopes{
    public static void main(String[] args) {
        Solution solution = new T354_RussianDollEnvelopes().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (a, b) -> {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            });
            int n = envelopes.length;

            int[] d = new int[n + 1];
            d[1] = envelopes[0][1];
            int size = 1;
            for (int i = 1; i < n; ++i) {
                int x = envelopes[i][1];
                if (x > d[size]) {
                    d[++size] = x;
                } else {
                    int left = 1, right = size;
                    while (left < right) {
                        int mid = (left + right) >> 1;
                        if (d[mid] >= x) {
                            right = mid;
                        } else {
                            left = mid + 1;
                        }
                    }
                    int p = d[left] >= x ? left : 1;
                    d[p] = x;
                }
            }
            return size;
        }
    }





//leetcode submit region end(Prohibit modification and deletion)

}
