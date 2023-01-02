#include<iostream>
#include<queue>
#include<utility>
using namespace std;
queue<pair<int,int>> q;
char arr[102][102]={0,};
bool visited[102][102]={0,};
int dist[102][102]={0,};
void bfs(int n,int m);
int main()
{
	int n,m;
	cin>>n>>m;
	for(int i=1;i<=n;i++)
	{
		for(int j=1;j<=m;j++)
		{
			cin>>arr[j][i];
			arr[j][i]-=48;
		}
	}
	bfs(n,m);
    cout<<dist[m][n]<<'\n';
	return 0;
	
}
void bfs(int n,int m)
{
	int dx[4]={0,0,1,-1};
	int dy[4]={1,-1,0,0};
	dist[1][1]=1;
	visited[1][1]=true;
	q.push({1,1});
	while(!q.empty())
	{
		int a=q.front().first;
		int b=q.front().second;
		q.pop();
		for(int i=0;i<4;i++)
		{
			int da=a+dx[i];
			int db=b+dy[i];
			if(visited[da][db]) continue;
			visited[da][db]=true;
			if(arr[da][db])
			{
				dist[da][db]=dist[a][b]+1;
				q.push({da,db});	
			}
		}
	}
	
}