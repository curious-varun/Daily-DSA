class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        final int N = customers.length;
        int satisfied = 0, masked = 0;
        for(int i=0; i<minutes; i++) {
            if(grumpy[i]==0) satisfied += customers[i];
            else masked += customers[i];
        }
        int maxMasked = masked;
        for(int left=0, right=minutes; right<N; right++) {
            if(grumpy[left]==1) masked -= customers[left];
            left++;
            if(grumpy[right]==0) satisfied += customers[right];
            else {
                masked += customers[right];
                maxMasked = Math.max(maxMasked, masked);
            }
        }
        return satisfied + maxMasked;
    }
}
