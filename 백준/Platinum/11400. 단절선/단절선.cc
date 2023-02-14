#include<bits/stdc++.h>
using namespace std;
vector<int> adj[100001];
int searchOrder[100001]={0};
int order = 1;
vector<pair<int, int>> ans;
int dfs(int now, int parent){
	searchOrder[now] = order++;
	int ret = searchOrder[now];
	for(int next : adj[now]){
		if(next == parent) continue;
		
		if(searchOrder[next]!=0){
			ret = min(ret, searchOrder[next]);
			continue;
		}
		int prev = dfs(next, now);
		
		if(prev > searchOrder[now]){
			ans.push_back({min(now, next), max(now ,next)});
		}
		ret = min(ret, prev);
	}
	return ret;
}

int main(){
	int n, m;
	cin>>n>>m;
	for(int i = 0; i < m; i++){
		int a, b;
		cin>>a>>b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	
	dfs(1, 0);
	int k = ans.size();
	cout<<k<<'\n';
	sort(ans.begin(),ans.end());
	for(auto x : ans){
		cout<<x.first<<" "<<x.second<<'\n';
	}
}