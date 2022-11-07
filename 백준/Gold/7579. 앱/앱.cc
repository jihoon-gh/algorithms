#include<iostream>
using namespace std;
int dp[101][10001]={0};
int memory[101]={0};
int cost[101]={0};
int n,m;

/*
	dp[i][j]에 대해
	i = 앱의 번호
	j = cost
	dp[i][j] i번까지 접근했을 때, j라는 cost로 가능한 메모리 사용량 

*/
int main(){
	
	cin>>n>>m;
	int costSum =0;
	for(int i=1;i<=n;i++){
		cin>>memory[i];
	}
	for(int i=1;i<=n;i++){
		cin>>cost[i];
		costSum += cost[i];
	}
	int ans = 2000000000;
	for(int i=1;i<=n;i++){
		for(int j=1;j<=costSum;j++){
			if(j>=cost[i]){
				dp[i][j]=max(dp[i-1][j-cost[i]]+memory[i],dp[i-1][j]);
			}else{
				dp[i][j]=dp[i-1][j];
			}
			if(dp[i][j]>=m){
				ans=min(ans,j);
			}
		}
	}

	cout<<ans<<'\n';
}