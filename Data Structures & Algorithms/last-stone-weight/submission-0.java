class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            int res = Math.abs(queue.poll() - queue.poll());
            if (res != 0) queue.add(res);
        }
        queue.add(0);
        return queue.poll();
    }
}
