class Solution {
    public String longestPalindrome(String s) {
        int count = 0;
        String res = "";
        if (s.isEmpty()) return "";

        int med = 0;
        int d = 0;

        while (med < s.length()) {
            d = 0;
            while (med - d > 0 && med + d + 1 < s.length() && s.charAt(med - d - 1) == s.charAt(med + d + 1)) {
                d++;
            }
            if (2 * d + 1 > count) {
                count = 2 * d + 1;
                res = s.substring(med - d, med + d + 1);
            }
            med++;
        }
        med = 0;
        
        while (med + 1 < s.length()) {
            while (med + 1 < s.length() && s.charAt(med) != s.charAt(med + 1)) {
                med++;
            }
            if (med + 1 >= s.length()) break;

            d = 0;
            while (med - d > 0 && med + d + 2 < s.length() && s.charAt(med - d - 1) == s.charAt(med + d + 2)) {
                d++;
            }
            if (2 * d + 2 > count) {
                count = 2 * d + 2;
                res = s.substring(med - d, med + d + 2);
            }
            med++;
        }
        return res;
    }
}
