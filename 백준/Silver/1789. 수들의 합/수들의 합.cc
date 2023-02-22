#include<bits/stdc++.h>
using namespace std;
int getRes(long long x){
	for(long long i = 1; ;i++){
		if(i*(i+1)/2 > x){
			return i - 1;
		}
	}
}

int main(){
	long long n; cin>>n;
	long long res = getRes(n);
	cout<<res<<'\n';
}