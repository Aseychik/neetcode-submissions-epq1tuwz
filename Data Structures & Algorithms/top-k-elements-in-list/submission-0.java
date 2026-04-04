class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i : nums)
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        
        int[][] freq = new int[hm.size()][2];

        int t = 0;
        for (Map.Entry<Integer, Integer> i : hm.entrySet()) {
            freq[t] = new int[] { i.getValue(), i.getKey() };
            t++;
        }

        Arrays.sort(freq, (a1, a2) -> a2[0] - a1[0]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = freq[i][1];
        }

        return res;
    }
}
