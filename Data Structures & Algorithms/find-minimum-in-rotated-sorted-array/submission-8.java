class Solution {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) return nums[0];

        int left = 0, right = nums.length - 1, target = nums[0];
        int t, m;
        while (left < right) {
            m = (left + right) / 2;
            t = nums[m];
            if (m != 0 && t < nums[m - 1]) return t;
            if (t < target) {
                right = m;
            }
            else left = m + 1;
        }
        //if (left >= nums.length - 1) left--;
        if (nums.length == 1) return nums[0];
        return nums[right];
    }
}
