class Solution {
    public boolean isPalindrome(String s) {
        char[] firstLine = s.toLowerCase().toCharArray();
        int left = 0, right = firstLine.length - 1;

        while (left < right) {
            while (left < firstLine.length && !Character.isLetterOrDigit(firstLine[left])) {
                left++;
            }
            while (right > 0 && !Character.isLetterOrDigit(firstLine[right])) {
                right--;
            }
            if (left < right) {
                if (firstLine[left] != firstLine[right])
                    return false;
                else {
                    left++;
                    right--;
                }
            }
        }
        return true;
    }
}
