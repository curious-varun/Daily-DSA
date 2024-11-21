impl Solution {
    pub fn count_unguarded(m: i32, n: i32, guards: Vec<Vec<i32>>, walls: Vec<Vec<i32>>) -> i32 {
        let mut board: Vec<Vec<i32>> = vec![vec![0; n as usize]; m as usize];

        // Mark walls and guards on the board
        for w in &walls {
            board[w[0] as usize][w[1] as usize] = 3; // Wall
        }
        for g in &guards {
            board[g[0] as usize][g[1] as usize] = 2; // Guard
        }

        // Function to mark guarded cells in a specific direction
        fn mark_direction(
            board: &mut Vec<Vec<i32>>,
            start: (usize, usize),
            delta: (isize, isize),
            m: usize,
            n: usize,
        ) {
            let (mut r, mut c) = start;
            let (dr, dc) = delta;
            while let Some(next_r) = r.checked_add_signed(dr) {
                if let Some(next_c) = c.checked_add_signed(dc) {
                    if next_r >= m
                        || next_c >= n
                        || board[next_r][next_c] == 2
                        || board[next_r][next_c] == 3
                    {
                        break;
                    }
                    board[next_r][next_c] = 1;
                    r = next_r;
                    c = next_c;
                } else {
                    break;
                }
            }
        }

        // Mark cells guarded by each guard
        for g in &guards {
            let (row, col) = (g[0] as usize, g[1] as usize);
            mark_direction(&mut board, (row, col), (1, 0), m as usize, n as usize); // Down
            mark_direction(&mut board, (row, col), (-1, 0), m as usize, n as usize); // Up
            mark_direction(&mut board, (row, col), (0, 1), m as usize, n as usize); // Right
            mark_direction(&mut board, (row, col), (0, -1), m as usize, n as usize);
            // Left
        }

        // Count unguarded cells
        board
            .iter()
            .flat_map(|row| row.iter())
            .filter(|&&cell| cell == 0)
            .count() as i32
    }
}
