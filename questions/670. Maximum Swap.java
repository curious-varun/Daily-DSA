class Solution {
    public int maximumSwap(int num) {
        List<Integer> al = new ArrayList<>();
        int m = num;
        while(m!=0)
        {
            int rem = m%10;
            al.add(rem);
            m = m/10;
        }
        Collections.reverse(al);
        List<Integer> al2 = new ArrayList<>(al);
        System.out.println(al);
        Collections.sort(al2,Collections.reverseOrder());
        System.out.println(al2);
        int c=0;
        for(int i=0;i<al.size();i++)
        {
            int small = al.get(i);
            int ind = al.lastIndexOf(al2.get(i));
            if(al.get(i)<al2.get(i))
            {
                
                al.set(i,al2.get(i));
                c++;
            }
           
            if(c==1)
            {
                 al.set(ind,small);
                 break;
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i:al)
        {
            sb.append(Integer.toString(i));
        }
        int ans = Integer.parseInt(sb.toString());
        return ans;
        
    }
}
