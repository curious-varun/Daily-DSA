class Solution {
private:
    int size;
public:
    bool solve(map<int, vector<int>>&graph, int node, int parent, vector<int>&vis, map<int, int>&position, vector<int>recStack){
        vis[node]=1;
        recStack[node]=1;
        for(auto ele: graph[node]){
            if(vis[ele]==1 && recStack[ele]==1)  return true;
            if(vis[ele]==0 && solve(graph, ele, node, vis, position, recStack)) return true;
        }
        position[node]=size-position.size()-1;
        return false;
    }
    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& rowConditions, vector<vector<int>>& colConditions) {
        size=k;
        map<int,vector<int>>row,col;
        for(auto v: rowConditions){
            row[v[0]].push_back(v[1]);
        }
        for(auto v: colConditions){
            col[v[0]].push_back(v[1]);
        }
        vector<int>visRow(k+1,0), visCol(k+1,0);
        vector<int>recStack(k+1,0);
        map<int, int>rowInd, colInd;
        for(int i=1; i<=k; i++){
            int a=0, b=0;
            if(visRow[i]==0) a=solve(row, i, -1, visRow, rowInd, recStack);
            if(visCol[i]==0) b=solve(col, i, -1, visCol, colInd, recStack);
            if(row.find(i)==row.end()) rowInd[i]= k-rowInd.size()-1;
            if(col.find(i)==col.end()) colInd[i]= k-colInd.size()-1;
            if(a||b) return {};

        }
        vector<vector<int>>res(k,vector<int>(k,0));
        for(int i=1; i<=k; i++){
            res[rowInd[i]][colInd[i]]=i;
        }
        return res;
    }
};

