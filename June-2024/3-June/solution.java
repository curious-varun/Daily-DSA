class Solution {
    public int appendCharacters(String s, String t) {
        int ans = 0 ; 
        for(int i = 0 ;i < s.length() && ans < t.length(); i++){
            if(s.charAt(i)==t.charAt(ans)) ans ++ ; 

        }
        return t.length()-ans ;
    }
}
