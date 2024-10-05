class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ll = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k){
            if (Math.abs(x - arr[left]) > Math.abs(x - arr[right])){
                left ++;
            } else {
                right --;
            }
        }

        for (int i = left; i <= right; i ++){
            ll.add(arr[i]);
        }

        return ll;
    }
}
