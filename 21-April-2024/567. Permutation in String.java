class Solution {
    public boolean checkInclusion(String s1, String s2){
        char[] tempArrays1 = s1.toCharArray();
        Arrays.sort(tempArrays1);
        String sortedS1 = new String(tempArrays1);

        for(int i =0;i<s2.length()-s1.length()+1;i++){
            String temp = s2.substring(i,i +s1.length());
            char[] tempArray = temp.toCharArray();
            Arrays.sort(tempArray);
            String sortedtemp = new String(tempArray);
            if(sortedS1.equals(sortedtemp)){
                return true;
            }
        }
        return false;

    }
}
