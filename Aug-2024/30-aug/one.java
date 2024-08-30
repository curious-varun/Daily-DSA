class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length ; Arrays.sort(piles);
        int end = piles[len-1] ; int start = 0 ;  
        int ans = end/h ; 
        while(start<=end){
            int mid = start+((end-start)/2) ; 
            if(check(piles,h,mid)){
                ans = mid ; 
                end = mid-1 ; 
            }
            else start =  mid+1;
        }
        
        return ans ; 
    }

    public boolean check(int[] piles, int h , int k ){
        if(k<=0) return false ;
        int time = 0 ; 
        for(int i = 0  ; i < piles.length ; i++){
            time += piles[i]/k ; 
            time += piles[i]%k == 0 ? 0 : 1 ;  
            if(time>h) return false ; 

        }
        return true ; 
        
    }
}
