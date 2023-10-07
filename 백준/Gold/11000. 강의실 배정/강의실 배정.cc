#include<bits/stdc++.h>
using namespace std;
vector<pair<int,int>> v;
priority_queue<int,vector<int>,greater<int>> q;
int main()
{
	int n;
	cin>>n;
	for(int i=0;i<n;i++)
	{
		int a,b;
		scanf("%d %d",&a,&b);
		v.push_back({a,b});
	}
	sort(v.begin(),v.end());
	q.push(v[0].second);
	for(int i=1;i<n;i++)
	{
		if(v[i].first<q.top())
		{
			q.push(v[i].second);
		}
		if(v[i].first>=q.top())
		{
			q.pop();
			q.push(v[i].second);
		}
	}
	cout<<q.size()<<'\n';
	return 0;
	
}