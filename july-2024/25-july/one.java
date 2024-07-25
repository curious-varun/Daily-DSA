import java.util.*;

public class one {
   public static void main(String[] args) {

   }

   public static int[] solver(int[] nums) {
      int len = nums.length;
      int[] ans = new int[len];
      int[] previous = new int[len];
      int[] next = new int[len];

      Stack<Integer> st = new Stack<>();

      // ! for the left to right -> previous
      for (int i = 0; i < len; i++) {

         while (!st.isEmpty() && nums[st.peek()] <= nums[i])
            st.pop();
         if (st.isEmpty())
            previous[i] = 0;
         else
            previous[i] = i - st.peek();

         st.push(i);

      }

      // ! print print previous
      for (int num : previous)
         System.err.println(num);

      // ! next
      for (int i = len - 1; i >= 0; i--) {
         while (!st.isEmpty() && nums[st.peek()] <= nums[i])
            st.pop();
         if (st.isEmpty())
            previous[i] = 0;
         else
            previous[i] = i - st.peek();

         st.push(i);
      }
      // ! print next
      for (int num : next)
         System.err.println(num);

      for (int i = 0; i < len; i++) {
         ans[i] = previous[i] + next[i];
      }

      return ans;

   }
}
