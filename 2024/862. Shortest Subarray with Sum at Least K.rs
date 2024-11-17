use std::collections::VecDeque;
use std::iter::once;

impl Solution {
    pub fn shortest_subarray(nums: Vec<i32>, k: i32) -> i32 {
        let sum_iter = nums.iter().scan(0, |a, &n| {
            *a += n as i64;
            Some(*a)
        });
        let pfx_sums = once(0).chain(sum_iter).collect::<Vec<_>>();

        let mut indices = VecDeque::new();
        let mut sub_len = usize::MAX;

        let k = k as i64;

        for (i, &sum) in pfx_sums.iter().enumerate() {
            while indices.front().map_or(false, |&j| sum - pfx_sums[j] >= k) {
                sub_len = sub_len.min(i - indices.pop_front().unwrap());
            }
            while indices.back().map_or(false, |&j| pfx_sums[j] >= sum) {
                indices.pop_back();
            }
            indices.push_back(i);
        }

        if sub_len == usize::MAX {
            -1
        } else {
            sub_len as i32
        }
    }
}

