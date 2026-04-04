class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] arr_s1 = new int[26];
        int[] arr_s2 = new int[26];
        int l = s1.length();
        
        for (char c : s1.toCharArray()) 
            arr_s1[c - 'a']++;
        
        for (int i = 0; i < l; i++)
            arr_s2[s2.charAt(i) - 'a']++;
        
        int cnt_dif = 0;
        for (int i = 0; i < 26; i++) {
            if (arr_s1[i] != arr_s2[i]) cnt_dif++;
        }
        if (cnt_dif == 0) return true;
        
        for (int i = l; i < s2.length(); i++) {
            int newChar = s2.charAt(i) - 'a';
            int oldChar = s2.charAt(i - l) - 'a';
            
            arr_s2[newChar]++;
            if (arr_s1[newChar] == arr_s2[newChar]) cnt_dif--;
            else if (arr_s1[newChar] == arr_s2[newChar] - 1) cnt_dif++;
            
            arr_s2[oldChar]--;
            if (arr_s1[oldChar] == arr_s2[oldChar]) cnt_dif--;
            else if (arr_s1[oldChar] == arr_s2[oldChar] + 1) cnt_dif++;
            
            if (cnt_dif == 0) return true;
        }
        
        return false;
    }
}