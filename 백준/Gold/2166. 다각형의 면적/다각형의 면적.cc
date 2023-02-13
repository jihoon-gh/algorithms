#include<bits/stdc++.h>
using namespace std;
vector<long long> vx;
vector<long long > vy; 
int main(){
	double ans = 0;
	int n; cin>> n;
	for(int i = 0 ; i < n; i++){
		int x, y;
		cin>>x>>y;
		vx.push_back(x);
		vy.push_back(y);
	}
	for(int i = 0; i< n - 1; i++){
		ans+=(vx[i]*vy[i+1] - vx[i+1]*vy[i]);
	}
	ans+=(vx[n-1]*vy[0] - vx[0]*vy[n-1]);
	ans = abs(ans);
	ans /= 2;
	printf("%.1f", ans);
}