class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        priority_queue<long long> pq;

        for(int i =0;i<nums.size();i++)  pq.push(nums[i]);

        long long sum=0;

        while(k>0){
            long long temp = pq.top();
            sum+=temp;
           

            pq.pop();
            long long  sc =  (temp+2)/3;
           
            pq.push(sc);
            k--;

        }
        return sum;
           
    }
};
