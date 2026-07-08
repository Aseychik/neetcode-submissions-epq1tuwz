class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);
        int[] d = new int[nums.length];
        d[0] = nums[0];
        d[1] = Math.max(nums[0], nums[1]);
        d[2] = Math.max(nums[0] + nums[2], nums[1]);
        for (int i = 3; i < nums.length; i++) {
            d[i] = Math.max(d[i - 2], d[i - 3]) + nums[i];
        }
        return Math.max(d[nums.length - 1], d[nums.length - 2]);
    }
}
