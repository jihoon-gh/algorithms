#include<bits/stdc++.h>
using namespace std;
int dp[1000001];
int first[1000001];
int main(){
	int x; cin>>x;
	dp[1] = 0;
	first[1] = 1;
	for(int i = 2 ; i <= x; i++){
		dp[i] = i;
		if(i % 3 == 0){
			if(dp[i/3] < dp[i]){
				dp[i] = dp[i/3] + 1;
				first[i] = i/3;
			}
		}
		if(i % 2 == 0){
			if(dp[i/2] < dp[i]){
				dp[i] = dp[i/2] + 1;
				first[i] = i/2;
			}
		}
		if(dp[i-1] < dp[i]){
			dp[i] = dp[i-1] + 1;
			first[i] = i-1;
		}
	}
	cout<<dp[x]<<'\n';
	cout<<x<<" ";
	while(x > 1){
		cout<<first[x]<<" ";
		x = first[x];
	
	}
	
}