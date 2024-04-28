class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> one = new HashSet<>() ; 
        HashSet<Integer> two = new HashSet<>() ; 

        for(int num : nums1 ) one.add(num);
        for(int num : nums2 ) two.add(num);

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for(int num : two) if(!one.contains(num)) first.add(num); 
        for(int num : one) if(!two.contains(num)) second.add(num); 

        List<List<Integer>> ans = new ArrayList<>();

        ans.add(second); ans.add(first);

        return ans ; 


        
    }
}
