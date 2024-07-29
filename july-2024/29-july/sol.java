class Solution {
    public int numTeams(int[] rating) {
        int[] minCount = new int[rating.length];
        int[] maxCount = new int[rating.length];
        int ans = 0;
        for(int i=0;i<rating.length;i++){
            for(int j=0;j<i;j++){
                if(rating[i]>rating[j]){
                    minCount[i]++;
                    ans += minCount[j];
                }
                if(rating[i]<rating[j]){
                    maxCount[i]++;
                    ans += maxCount[j];
                }
            }
        }

        return ans;
    }
}
