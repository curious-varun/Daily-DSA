func luckyNumbers (matrix [][]int) []int {
    m := len(matrix)
    n := len(matrix[0])
    row := make([]int , m)
    col := make([]int ,  n)
    ans := []int{}

    for i:= 0 ; i< m ; i++{
        currentMini := int(^uint(0) >> 1)
        for j := 0 ;j< n ;j++{
            if matrix[i][j] < currentMini{
                currentMini = matrix[i][j]
            }
        } 
        row[i] = currentMini
    }
    for i := 0; i < n; i++ {
		currentMaxi := -int(^uint(0)>>1) - 1 // Initialize to minimum int value
		for j := 0; j < m; j++ {
			if matrix[j][i] > currentMaxi {
				currentMaxi = matrix[j][i]
			}
		}
		col[i] = currentMaxi
	}
    for i:= 0 ; i<m ;i++{
        for j:= 0 ;j <n ;j++{
            if row[i] == matrix[i][j] && col[j] == matrix[i][j]{
                ans = append(ans , matrix[i][j])
            }
        }
    }
  return ans
}

	
