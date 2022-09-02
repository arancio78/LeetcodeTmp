class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); ++mask) {//从0～2^n-1个状态
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < n; ++i) {//遍历二进制的每一位
                if (((mask >> i) & 1) == 1) {//判断二进制第j位是否存在
                    t.add(nums[i]);
                }
            }
            ans.add(t);
        }
        return ans;
    }
}
