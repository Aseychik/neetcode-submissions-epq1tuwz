class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Integer, Integer> h1 = new HashMap<>(), h2 = new HashMap<>();

        s.chars().forEach(ch -> h1.put(ch, h1.containsKey(ch) ? h1.get(ch) + 1 : 1));
        t.chars().forEach(ch -> h2.put(ch, h2.containsKey(ch) ? h2.get(ch) + 1 : 1));
        
        if (h1.size() != h2.size()) return false;
        if (!h1.keySet().equals(h2.keySet())) return false;
        if (!h1.equals(h2)) return false;
        return true;
    }
}
