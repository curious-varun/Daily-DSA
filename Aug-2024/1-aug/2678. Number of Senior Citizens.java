class Solution {
    public int countSeniors(String[] strs ) {
        int count = 0 ;

        for(String s : strs ) { 
            char ch = s.charAt(s.length()  - 4) ; 
            if(ch == '6' && s.charAt(s.length()-3) !='0') count ++ ; 
            else if ( ch == '7' || ch == '8' || ch == '9') count ++ ; 
            else continue ; 
        }   
    
        return count ; 
    }
}



