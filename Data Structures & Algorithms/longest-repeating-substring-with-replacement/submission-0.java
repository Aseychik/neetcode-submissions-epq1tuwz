class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int[] cnts = new int[26];
        int mx = 0;
        char[] ch = s.toCharArray();
        boolean b;

        for (int i = 0; i < ch.length; i++) {
            cnts[ch[i] - 'A']++;
            b = false;
            while (!b && start <= i) {
                for (int j : cnts) {
                    if (i - start - j + 1 <= k) {
                        b = true;
                        break;
                    }
                }
                if (!b) {
                    cnts[ch[start] - 'A']--;
                    start++;
                }
            }
            mx = Math.max(mx, i - start + 1);
        }
        return mx;
    }
}
