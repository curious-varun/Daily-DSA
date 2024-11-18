impl Solution {
    pub fn decrypt(c: Vec<i32>, k: i32) -> Vec<i32> {
        (0..c.len() as i32)
            .map(|i| {
                (i.min(i + k)..=i.max(i + k))
                    .map(|j| c[(j as usize + c.len()) % c.len()])
                    .sum::<i32>()
                    - c[i as usize]
            })
            .collect()
    }
}
