class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int fd = search2(matrix, target);
        if (fd == -1) return false;
        int res = search(matrix[fd], target);
        return res != -1;
    }

    public int search2(int[][] nums, int target) {
        int mm = nums[0].length - 1;
        int left = 0, right = nums.length;
        int m;

        while (left < right) {
            m = (left + right) / 2;
            if (target > nums[m][mm]) {
                left = m + 1;
            }
            else {
                if (nums[m][0] <= target && target <= nums[m][mm]) return m;
                else right = m;
            }
        }
        if (left < nums.length && nums[left][0] <= target && target <= nums[left][mm]) return left;
        return -1;
    }

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
