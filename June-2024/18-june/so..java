import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] d, int[] p, int[] worker) {
        int len = p.length;
        Data[] data = new Data[len];
        
        for (int i = 0; i < len; i++) {
            data[i] = new Data(d[i], p[i]);
        }
        
        Arrays.sort(data, (a, b) -> a.d - b.d);
        Arrays.sort(worker);
        
        int maxProfit = 0;
        int maxP = 0;
        int j = 0;
        
        for (int w : worker) {
            while (j < len && w >= data[j].d) {
                maxP = Math.max(maxP, data[j].p);
                j++;
            }
            maxProfit += maxP;
        }
        
        return maxProfit;
    }
}

class Data {
    int d;
    int p;
    
    Data(int d, int p) {
        this.d = d;
        this.p = p;
    }
}

