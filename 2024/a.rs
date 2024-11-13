impl Solution {
    pub fn count_fair_pairs(mut nums: Vec<i32>, lower: i32, upper: i32) -> i64 {
        nums.sort(); (0..nums.len()).map(|i| nums[..i].partition_point(|y| nums[i] + y <= upper) - nums[..i].partition_point(|y| nums[i] + y < lower)).sum::<usize>() as i64
    }
}
