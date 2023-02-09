#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
vector<int> v;
int getRes(){
	int res = 0;
	for(int i = 0; i < v.size() - 1; i++){
		res += abs(v[i] - v[i+1]);
	}
	return res;
}
int main(){
	
	int n; cin>>n;
	for(int i = 0; i < n; i++){
		int t; cin>>t;
		v.push_back(t);
	}
	int ans = 0;
	sort(v.begin(), v.end());
	while(next_permutation(v.begin(), v.end())){
		ans = max(ans, getRes());
	}
	cout<<ans<<'\n';
	
}