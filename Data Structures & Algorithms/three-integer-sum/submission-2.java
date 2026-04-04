class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int left, right;
        Arrays.sort(nums);
        int target, sm;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            left = i + 1;
            right = nums.length - 1;
            target = -nums[i];

            while (left < right) {
                sm = nums[left] + nums[right];

                if (sm == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;

                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sm < target) {
                    left++;
                }
                else right--;
            }
        }
        return res;
    }
}
