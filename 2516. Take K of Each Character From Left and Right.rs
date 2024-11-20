Solution {
    pub fn take_characters(s: String, k: i32) -> i32 {
        let n = s.len();
        if k == 0 {
            return 0;
        }

        let mut counts = [0; 3];
        for c in s.chars() {
            counts[(c as usize - 'a' as usize)] += 1;
        }

        if counts[0] < k || counts[1] < k || counts[2] < k {
            return -1;
        }

        let mut current = [0; 3];
        let mut max_middle = 0;
        let mut left = 0;
        let chars: Vec<char> = s.chars().collect();

        for right in 0..n {
            current[(chars[right] as usize - 'a' as usize)] += 1;

            while left <= right && (
                current[0] > counts[0] - k ||
                current[1] > counts[1] - k ||
                current[2] > counts[2] - k) {
                current[(chars[left] as usize - 'a' as usize)] -= 1;
                left += 1;
            }

            max_middle = max_middle.max(right - left + 1);
        }

        (n - max_middle) as i32
    }
}
