class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0 ; int len = people.length ;
        Arrays.sort(people);
        int start = 0 ; int end = len -1 ; 
        while(start<end){
            if(people[start]+people[end] <= limit ) {
                start ++ ; end -- ; 
                boats++;
            }
            else{
                boats ++ ; 
                end -- ; 
            }
        }
            if(start==end)boats++;
        return boats ; 
    }
}
