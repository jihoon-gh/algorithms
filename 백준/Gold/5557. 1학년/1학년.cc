#include<bits/stdc++.h>
using namespace std;
long long dp[101][21] = {0};
int arr[101] = {0};
int main(){
	int n; cin>>n;
	for(int i = 1; i <= n; i++){
		cin>>arr[i];
	}
	dp[1][arr[1]] = 1;
	for(int i = 2; i <= n-1; i++){
		for(int j = 0; j <= 20; j++){
			if(j - arr[i] >= 0){
				dp[i][j] += dp[i-1][j-arr[i]];
			}
			if(j + arr[i] <= 20){
				dp[i][j] += dp[i-1][j+arr[i]];
			}
		}
	}
	cout<<dp[n-1][arr[n]]<<'\n';
}