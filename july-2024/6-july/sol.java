class Solution {
    public int passThePillow(int n, int time) {
        int[]a=new int[2*n-2];
        for(int i=0;i<n;i++){
            a[i]=i+1;
        }
        for(int i=n;i<2*n-2;i++){
            a[i]=2*n-1-i;
        }
        return a[time%(2*n-2)];
    }
}
