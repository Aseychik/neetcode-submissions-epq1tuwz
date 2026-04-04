class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr_s1 = new int[26];
        int[] arr_s2 = new int[26];
        int l = s1.length();

        char[] ch = s2.toCharArray();

        for (char c : s1.toCharArray()) 
            arr_s1[c - 'a']++;

        for (int i = 0; i < l - 1; i++)
            arr_s2[ch[i] - 'a']++;

        for (int i = l - 1; i < ch.length; i++) {
            arr_s2[ch[i] - 'a']++;
            if (Arrays.equals(arr_s1, arr_s2)) return true;
            arr_s2[ch[i - l + 1] - 'a']--;
        }
        return false;
    }
}
