class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left = 1, right = 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = 1;
        
        for (int i = 0; i < n; i++) {
            res[i] *= left;
            res[n - i - 1] *= right;
            left *= nums[i];
            right *= nums[n - i - 1];
        }

        return res;
    }
}  
