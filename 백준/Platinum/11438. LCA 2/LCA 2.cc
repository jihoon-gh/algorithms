#include<bits/stdc++.h>
#define MAX_NODE 100001
using namespace std;
vector<int> adj[MAX_NODE];
int ac[MAX_NODE][20];
int depth[MAX_NODE];
int level;

void makeTree(int cur, int parent){
	depth[cur] = depth[parent] + 1;
	ac[cur][0] = parent;
	level = (int)floor(log2(MAX_NODE));
	
	for(int i = 1; i<= level; i++){
		int tmp = ac[cur][i-1];
		ac[cur][i] = ac[tmp][i-1];
	}
	
	for(auto x : adj[cur]){
		if(x != parent){
			makeTree(x, cur);
		}
	}
}

int main(){
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n; cin>>n;
	for(int i = 0; i < n-1; i++){
		int a, b;
		cin>> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	
	depth[0] = -1;
	makeTree(1, 0);
	
	int m; cin >> m;
	for(int i = 0; i < m; i++){
		int a, b;
		cin>> a >>b;
		if(depth[a] != depth[b]){
			if(depth[a] > depth[b]){
				swap(a, b);
			}
		}
		
		for(int i = level; i >= 0; i--){
			if(depth[a] <= depth[ac[b][i]]){
				b = ac[b][i];
			}
		}
		
		int lca = a;
		if(a==b){
			cout<<lca<<'\n';
			continue;
		}
		for(int i = level; i>=0; i--){
			if(ac[a][i] != ac[b][i]){
				a = ac[a][i];
				b = ac[b][i];
			}
			lca = ac[a][i];
		}
	cout<<lca<<'\n';
	}
}