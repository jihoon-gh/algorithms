#include<bits/stdc++.h>
using namespace std;

map<string, int> m;
vector<string> v;
bool comp(string s1, string s2){
	if(m[s1]==m[s2]){
		if(s1.size()==s2.size()){
			return s1 < s2;
		}
		else{	
			return s1.size() > s2.size();
		}
	}
	else{
		return m[s2] < m[s1];
	}
}
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n, ma;
	cin>>n>>ma;
	for(int i = 0; i < n; i++){
		string s;
		cin>>s;
		if(s.size( )< ma) continue;
		m[s]++;
		if(m[s]==1){
			v.push_back(s);
		}
	}
	sort(v.begin(),v.end(),comp);
	for(string s : v){
		cout<<s<<'\n';
	}
}