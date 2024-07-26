class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = getMinDistMatrix(edges, n), cityCnt = n, cityNo = 0;
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(dist[i][j] <= distanceThreshold) cnt++;
            }
            if(cnt <= cityCnt){
                cityCnt = cnt;
                cityNo = i;
            }
        }
        return cityNo;
    }
 
    private int[][] getMinDistMatrix(int[][] edges, int n) {
		int[][] dist = new int[n][n];
		for(int[] arr : dist)Arrays.fill(arr, Integer.MAX_VALUE);
		for(int[] e : edges) dist[e[0]][e[1]] = dist[e[1]][e[0]] = e[2];
		for(int i=0; i<n; i++)dist[i][i] = 0;
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		return dist;
	}
}
