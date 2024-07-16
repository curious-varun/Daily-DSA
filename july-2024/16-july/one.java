class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
      
      int n=positions.length;
      
      Integer[] indexes= new Integer[n];
      List<Integer> result= new ArrayList<>();
      for(int i=0;i<n;i++){
        indexes[i]=i;
      }

      Arrays.sort(indexes,(x,y)->Integer.compare(positions[x],positions[y]));

      Stack<Integer> stack= new Stack<>();

      for(int i:indexes){
        if(directions.charAt(i)=='R'){
            stack.push(i);
        }else{
          while(!stack.isEmpty()&&healths[i] > 0){
              int topIndex=stack.peek();
              if(healths[topIndex]>healths[i]){
                healths[topIndex] -=1;
                healths[i]=0;
              }else if(healths[topIndex]<healths[i]){
                healths[i] -=1;
                healths[topIndex]=0;
                stack.pop();
              }else{
                healths[topIndex]=0;
                healths[i]=0;
                stack.pop();
              }
            }  
        }
       }

       for(int index=0;index<n;index++){
        if(healths[index]>0){
            result.add(healths[index]);

        }
       }
return result;
    }
}
