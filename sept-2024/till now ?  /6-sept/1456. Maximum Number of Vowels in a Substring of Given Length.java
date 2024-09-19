class Solution {
    public int maxVowels(String s, int k) {
      int asn = 0 ; int len = s.length() ; 
      int start = 0 ; int end = 0 ; 
      int max = 0 ; int count = 0 ;
      while(end < k ){
        if(check(s.charAt(end))) count ++ ; 
        end++ ;
      }
      while(end < len ) {
       max = Math.max(count , max ) ; 
       if(check(s.charAt(start++))) count -- ; 
       if(check(s.charAt(end++))) count ++ ; 
      }
      max = Math.max(count , max ) ; 
      return max ;
    }

    public boolean check ( char ch ) {
        if(ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o'|| ch == 'u') return true ; 
        else return false ;  
    }

}
