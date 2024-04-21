class Solution {
    public int maxScore(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        int sum = 0;

        // Initialize sum with the first k elements
        for (int i = len - k; i < len; i++)
            sum += nums[i];

        ans = sum; // Initialize ans with the initial sum

        // Sliding window approach to find the maximum sum
        for (int i = 1; i <= k; i++) {
            sum = sum - nums[len - k + i - 1] + nums[i - 1]; // Update the sum by excluding the first element and including the next element
            ans = Math.max(ans, sum); // Update the maximum sum
        }

        return ans;
    }
}
import java.util.HashMap;

class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int len = s.length() ; 
        int count = 0 ; 
        int start = 0; 
        int end = 0 ;

        while(end<len){
            if(map.size()==3){
                // add count 
                count += len-end;
                // remove things  
                while(start<end && map.size()==3){
                    map.put(s.charAt(start) , map.getOrDefault(s.charAt(start),0) - 1);
                    if(map.get(s.charAt(start)) <= 0 )  map.remove(s.charAt(start));
                    start++ ; 
                    if(map.size()==3) count += len - end ; 
                }
            }
            map.put(s.charAt(end) , map.getOrDefault(s.charAt(end), 0) + 1);
            end++ ; 
        }
        
        return count ;
    }
}

