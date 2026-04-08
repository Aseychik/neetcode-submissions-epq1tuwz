class Solution {
    public int search(int[] nums, int target) {
        int shift = findMin(nums);
        int n = nums.length;
        
        int left = 0, right = n - 1;
        
        while (left <= right) {
            int m = (left + right) / 2;
            int realMid = (m + shift) % n;
            
            if (nums[realMid] == target) return realMid;
            if (nums[realMid] < target) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return -1;
    }

    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) return 0;

        int left = 0, right = nums.length - 1, target = nums[0];
        int t, m;
        while (left < right) {
            m = (left + right) / 2;
            t = nums[m];
            if (m != 0 && t < nums[m - 1]) return m;
            if (t < target) {
                right = m - 1;
            }
            else left = m + 1;
        }
        return right;
    }
}
