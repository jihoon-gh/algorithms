#include<iostream>
#include<cmath>
using namespace std;
int arr[100001]={0};
int st[100001][21]={0};
int lg[100001]={0};
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=1;i<=100001;i++){
		lg[i]=(int)log2(i);
	}
	
	int n,m;
	cin>>n>>m;
	for(int i=0;i<n;i++){
		cin>>arr[i];
	}
	
	for(int i=0;i<n;i++){
		st[i][0]=arr[i];
	}
	
	for(int j=1;j<lg[n]+1;j++){
		for(int i=0;i<n;i++){
			if(i+(1<<j)>n) break;
			st[i][j]=min(st[i][j-1],st[i+(1<<(j-1))][j-1]);	
		}
	}
	
	for(int i=0;i<m;i++){
		int a,b;
		cin>>a>>b;
		a--;
		b--;
		int len = b-a+1;
		int k = lg[len];
		int res = min(st[a][k],st[b-(1<<k)+1][k]);
		cout<<res<<'\n';
	}
	return 0;
	
}
