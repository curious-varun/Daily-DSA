class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder() ; 
        Queue<Character> q = new LinkedList<>();
        Stack<Character> st = new Stack<>();
        int len = s.length();



        for(int i = 0 ; i < len ; i++){
            char curr = s.charAt(i);
            if(curr == ')'){
//                while(st.peek()!='(' || !st.isEmpty()) q.offer(st.pop());
                while(st.isEmpty()==false){
                    if(st.peek()=='(') {st.pop() ; break ;}
                    else q.offer(st.pop());
                }
                while(q.isEmpty()==false) st.push(q.poll());
            }
            else st.push(curr) ; 
        }


        while(!st.isEmpty()) sb.insert(0,st.pop());
        
        return sb.toString();

//        return sb.reverse().toString() ; 
    }
}
