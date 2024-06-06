import java.util.*;

class TimeMap {
    HashMap<String, List<Pair>> map; 
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            map.get(key).add(new Pair(value, timestamp));
        } else {
            map.put(key, new ArrayList<Pair>());
            map.get(key).add(new Pair(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return ""; 
        List<Pair> ll = map.get(key);

        Collections.sort(ll);

        return search(ll, timestamp, 0, ll.size() - 1);
    }

    private String search(List<Pair> ll, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (ll.get(mid).time == target) {
                return ll.get(mid).value;
            } else if (ll.get(mid).time < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end >= 0 ? ll.get(end).value : "";
    }

    class Pair implements Comparable<Pair> { 
        String value; 
        int time;

        Pair(String value, int time) {
            this.value = value; 
            this.time = time; 
        }

        @Override
        public int compareTo(Pair other) {
            return this.time - other.time;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

