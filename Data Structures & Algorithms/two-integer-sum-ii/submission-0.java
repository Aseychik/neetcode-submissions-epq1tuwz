class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int sm = numbers[left] + numbers[right];
        while (sm != target) {
            if (sm > target) right--;
            if (sm < target) left++;
            sm = numbers[left] + numbers[right];
        }
        return new int[] { left + 1, right + 1 };
    }
}
