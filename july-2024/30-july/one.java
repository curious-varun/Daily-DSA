class Solution {
    public int minimumDeletions(String s) {
        int[] aCount=new int[s.length()];
        aCount[s.length()-1]=0;
        for(int i=s.length()-2;i>=0;i--)
        {
            aCount[i]=aCount[i+1];
            aCount[i]+=(s.charAt(i+1)=='a')?1:0;
        }
        int b=0;
        int res=s.length();
        for(int m=0;m<s.length();m++)
        {
            res=Math.min(res,b+aCount[m]);
            b+=(s.charAt(m)=='b')?1:0;
        }
        return res;   
    }
}
