#include<bits/stdc++.h>
using namespace std;
vector<int> v;
int main(){
	int n; cin>>n;
	for(int i = 0; i < n; i++){
		int k; cin >> k;
		v.push_back(k);
	}
	sort(v.begin(), v.end());
	
	int left = 0;
	int right = v.size()-1;
	int ans_left = left;
	int ans_right = right;
	int k = 2000000000;
	while(left<right){
		
		int tmp = v[left] + v[right];
		if(k > abs(tmp)){
			ans_left = left;
			ans_right = right;
			k = abs(tmp);
		}
		if(tmp < 0){
			left++;
		}
		else{
			right--;
		}
	}
	cout<<v[ans_left]<<" "<<v[ans_right]<<'\n';
}