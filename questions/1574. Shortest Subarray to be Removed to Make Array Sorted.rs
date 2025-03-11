impl Solution {
    pub fn find_length_of_shortest_subarray(arr: Vec<i32>) -> i32 {
        let n = arr.len();
        let (mut l, mut h) = (0, n - 1);
        while h > 0 && arr[h - 1] <= arr[h] {
            h -= 1
        }
        let mut res = h;
        while l < h && h <= n && (l < 1 || arr[l] >= arr[l - 1]) {
            if h == n || arr[l] <= arr[h] {
                res = res.min(h - l - 1);
                l += 1
            } else {
                h += 1
            }
        }
        res as i32
    }
}
