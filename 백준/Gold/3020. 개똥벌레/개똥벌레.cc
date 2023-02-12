#include<bits/stdc++.h>
using namespace std;

int arr[2000000]={0};
int res[500001];
void edit(int left, int right, int s){
	left = left + s -1;
	right = right + s - 1;
	while(left<=right){
		if(left % 2 == 1){
			arr[left]++;
			left++;
		}
		if(right % 2 == 0){
			arr[right]++;
			right--;
		}
		left /= 2;
		right /= 2;
	}
}
int getSum(int x, int s){
	x = x + s - 1;
	int res = 0;
	while( x > 0){
		res  += arr[x];
		x /= 2;
	}
	return res;
}

int main(){
	int n, h;
	cin>>n>>h;
	int s = 1;
	while(s < h){
		s *= 2;
	}
	for(int i = 0; i < n; i++){
		int x;
		cin>>x;
		if(i % 2 == 0){
			edit(1, x, s);
		}
		else{
			edit(h - x  +1, h, s);
		}
	}
	for(int i = 1; i <= h ; i++){
		res[i] = getSum(i, s);
	}
	int ans  = 987654321;
	int cnt = 0;
	for(int i = 1;  i<= h; i++){
		if(res[i]<ans){
			cnt = 1;
			ans = res[i];
		}
		else if(res[i] == ans){
			cnt++;
		}
	}
	cout<<ans<<" "<<cnt<<'\n';
	
}