def solveNQueens(n):
    result = []
    board = [["." for _ in range(n)] for _ in range(n)]
    def is_safe(row, col):
        for i in range(row):
            if board[i][col] == "Q":
                return False
        i, j = row, col
        while i >= 0 and j >= 0:
            if board[i][j] == "Q":
                return False
            i -= 1
            j -= 1
        i, j = row, col
        while i >= 0 and j < n:
            if board[i][j] == "Q":
                return False
            i -= 1
            j += 1
        return True
    def solve(row):
        if row == n:
            result.append(["".join(r) for r in board])
            return
        for col in range(n):
            if is_safe(row, col):
                board[row][col] = "Q"
                solve(row + 1)
                board[row][col] = "."
    solve(0)
    return result

# Test with an 8x8 board
solutions = solveNQueens(8)
print(f"Number of solutions for 8-Queens: {len(solutions)}")
for solution in solutions:
    for row in solution:
        print(row)
    print("\n")

