#include<bits/stdc++.h>
using namespace std; 

void print(vector<int>&v){
    cout<<v.size()<<endl; 
}

void f(){
    int n; 
    cin>>n;
    vector<int>v (n); 
    for(int i=0;i<n;i++){
        cin>>v[i]; 
    }
    
    vector<int>ans; 
    if(v.size()==1){
        return print(v); 
    }
    if(v.size()==2){
        if(v[0] == v[1]){
            ans.push_back(v[0]); 
            return print(ans); 
        }
        return print(v); 
    }
    ans.push_back(v[0]); 

    for(int i=1 ; i< v.size()-1;i++){
        if((ans.back() < v[i] && v[i] > v[i+1]) || (ans.back() > v[i] && v[i] < v[i+1])){
            ans.push_back(v[i]); 
        }
    }
    ans.push_back(v.back()); 
    if(ans.size()==2){
        if(ans[0] == ans[1]){
            ans.pop_back();
            return print(ans); 
        }
    }
    return print(ans); 
}


int main(){
    int t; 
    cin>>t; 
    while(t--){
        f(); 
    }
    return 0 ; 
}
