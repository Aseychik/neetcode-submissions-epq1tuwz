class Solution {
    public int lengthOfLongestSubstring(String s) {
        int st = 0, ml = 1;
        if (s.length() == 0) return 0;

        char[] c = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        Integer t;
        for (int i = 0; i < c.length; i++) {
            t = hm.get(c[i]);
            if (!(t == null) && t != -1) {
                ml = Math.max(ml, i - st);
                for (int j = st; j < t; j++) {
                    hm.put(c[j], -1);
                }
                hm.put(c[i], i);
                st = t + 1;
            } 
            else
                hm.put(c[i], i);
        }
        ml = Math.max(ml, c.length - st);
        return ml;
    }
}
