#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main(){
	
	int n;
	cin>>n;
	vector<int> v;
	for(int i=0;i<n;i++){
		int k;
		cin>>k;
		v.push_back(k);
	}
	sort(v.begin(),v.end());
	int ans = 0;
	for(int i=0;i<n;i++){
		ans = max(v[i]*(n-i),ans);
	}
	cout<<ans<<'\n';
	
}