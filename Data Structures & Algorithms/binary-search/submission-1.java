class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        int m;

        while (left < right) {
            m = (left + right) / 2;
            if (target > nums[m]) {
                left = m + 1;
            }
            else {
                if (target == nums[m]) return m;
                else right = m;
            }
        }
        if (left < nums.length && nums[left] == target) return left;
        return -1;
    }
}
