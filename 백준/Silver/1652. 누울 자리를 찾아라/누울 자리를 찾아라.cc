#include<bits/stdc++.h>
using namespace std;
vector<string> v;
int main(){
	int n; cin>> n;
	
	for(int i = 0 ; i < n; i++){
		string s; cin>>s;
		v.push_back(s);
	}
	int ans1 = 0;
	for(int i = 0; i < v.size(); i++){
		int count = 0;
		for(int j = 0; j < v[i].size(); j++){
			if(v[i][j]=='.'){
				count++;
			}
			if(v[i][j]!='.'){
				if(count >= 2){
					ans1++;
				}
				count = 0;
			}
		}
		if(count>=2){
			ans1++;
		}
	}
	int ans2 = 0;
	for(int i = 0; i < n; i++){
		int count = 0;
		for(int j = 0; j <n; j++){
			if(v[j][i]=='.'){
				count++;
			}
			if(v[j][i]!='.'){
				if(count >= 2){
					ans2++;
				}
				count = 0;
			}
		}
		if(count>=2){
			ans2++;
		}
	}
	
	cout<<ans1<<" "<<ans2<<'\n';
}