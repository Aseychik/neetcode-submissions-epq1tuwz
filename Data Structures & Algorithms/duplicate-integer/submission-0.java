class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i : nums) {
            if (hm.get(i) != null) return true;
            hm.put(i, true);
        } 
        return false;
    }
}