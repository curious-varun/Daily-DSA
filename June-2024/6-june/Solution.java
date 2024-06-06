class Solution {
    public boolean isNStraightHand(int[] hand, int size) {
        if (hand.length % size != 0) return false;
        int len = hand.length;
        Arrays.sort(hand);

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(hand[i]))
                pq.offer(hand[i]);
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        while (!pq.isEmpty()) {
            int num = pq.peek();
            int freq = map.get(num);
            for (int i = 0; i < size - 1; i++) {
                if ((!map.containsKey(num + 1)) || map.get(num + 1) < freq)
                    return false;
                else {
                    map.put(num + 1, map.getOrDefault(num + 1, 0) - freq);
                    if (map.get(num + 1) <= 0) {
                        map.remove(num + 1);
                        pq.poll();
                    }
                    num++;
                }
            }
            pq.poll();
        }

        return true;

    }
}
