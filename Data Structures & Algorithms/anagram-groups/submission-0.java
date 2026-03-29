class Solution {
    List<Integer> getMapFromString(String s) {
        List<Integer> hm = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            hm.add(0);
        }
        if (s.length() == 0) return hm;
        s.chars().forEach(ch -> hm.set(ch - 'a', hm.get(ch - 'a') + 1));
        return hm;
    }
    
    
    public List<List<String>> groupAnagrams(String[] strs) {
        //List<List<Integer>> hms = new ArrayList<>(strs.length);
        HashMap<List<Integer>, List<String>> hhm = new HashMap<>();


        List<String> t = new ArrayList<>();
        List<Integer> hms;
        for  (int i = 0; i < strs.length; i++) {
            hms = getMapFromString(strs[i]);
            hhm.computeIfAbsent(hms, k -> new ArrayList<>()).add(strs[i]);
/*            if (hhm.containsKey(hms)) {
                hhm.get(hms).add(strs[i]);
            }
            else {
                t = new ArrayList<>();
                t.add(strs[i]);
                hhm.put(getMapFromString(strs[i]), t);
            }*/
        }
//        List<List<String>> res = new ArrayList<>(hhm.values());

        return new ArrayList<>(hhm.values());
    }
}
