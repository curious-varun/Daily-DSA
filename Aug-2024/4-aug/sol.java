public class Solution {  
    public int rangeSum(int[] nums, int n, int left, int right) {  
        List<Long> arr = new ArrayList<>();  
        
        for (int i = 0; i < n; i++) {  
            long s = 0;  
            for (int j = i; j < n; j++) {  
                s += nums[j];  
                arr.add(s);  
            }  
        }  
        
        Collections.sort(arr);  
        
        long mod = 1000000007;  
        long result = 0;  
        
        for (int i = left - 1; i < right; i++) {  
            result = (result + arr.get(i)) % mod;  
        }  
        
        return (int) result;  
    }  
}

