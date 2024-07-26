import java.util.PriorityQueue;

public class one {
  public static void main(String[] args) {
      for(int i = 0 ;i < len ; i ++ ) {
        System.out.println(" this is the mian code " ) ;
      } 
      int[] nums = new int[] { 1 , 3 ,5, 6, 6, 7,7 ,7 ,6 } ; 

  }
}

class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}


