#include<bits/stdc++.h>
using namespace std;
vector<int> v;
int maxMoney = 0;
bool isValid(int x, int m){
	if(maxMoney > x) return false;
	int res = 0;
	int current = 0;
	for(auto k : v){
		if(k > current){
			res++;
			current = x - k;
		}else{
			current -=k;
		}
	}
	if(res <= m){
		return true;
	}
	else return false;
}
int binarySearch(int n, int m){
	
	int x = -1;
	for(int b = 1000000001; b >= 1; b /= 2){
		while(!isValid(b+x, m)) x += b;
	}
	return x + 1;
}
int main(){
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int n, m;
	cin>>n>>m;
	for(int i = 0; i < n; i++){
		int k; cin>>k;
		v.push_back(k);
		maxMoney = max(k, maxMoney);
	}
	int ans = binarySearch(n, m);
	cout<<ans<<'\n';
}