class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], 1);
        }
        int longest = 1, nowc = 0, now = 0;
        for (HashMap.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (!hm.containsKey(entry.getKey() - 1) && hm.containsKey(entry.getKey() + 1)) {
                nowc = 2;
                now = entry.getKey() + 2;
                while (hm.containsKey(now)) {
                    nowc++;
                    now++;
                }
                longest = Math.max(nowc, longest);
            }
        }
        return longest;
    }
}
