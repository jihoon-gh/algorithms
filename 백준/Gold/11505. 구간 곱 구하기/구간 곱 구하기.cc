#include<bits/stdc++.h>
using namespace std;
void edit(int, int);
int getSum(int left, int right);
int s= 1;
long long arr[2100000]={0};
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n, m, k;
	cin>>n>>m>>k;
	while(s < n){
		s <<= 1;
	}
	for(int i = 1; i <= 2 * s - 1; i++){
		arr[i] = 1;
	}
	
	for(int i = s; i <= s + n - 1; i++){
		cin>>arr[i];
	}
	
	for(int i = s; i <= 2 * s -1; i++){
		int k = i;
		while(k > 0){
			arr[k/2] = ((arr[k/2] % 1000000007) * (arr[i] % 10000000007))% 1000000007;
			k /= 2;
		}
	}
	for(int i = 0; i < m + k; i++){
		int a, b, c;
		cin>>a>>b>>c;
		if(a == 1){
			edit(b, c);
		}
		if(a == 2){
			cout<<getSum(b, c)<<'\n';
		}
	}
}
void edit(int b, int c){
	
	b = b + s - 1;
	int before = arr[b];
	arr[b] = c;
	int k = b / 2;
	while(k > 0){
		arr[k] = ((arr[k * 2 + 1] % 1000000007) * (arr[k * 2] % 1000000007)) % 1000000007;
		k /= 2;
	}
}
int getSum(int left, int right){
	left = left + s -1;
	right = right + s -1;
	int res = 1;
	while(left <= right){
		if(left % 2 == 1){
			res = ((res % 1000000007) * (arr[left] % 1000000007)) % 1000000007;
			left++;
		}
		if(right % 2 == 0){
			res  = ((res % 1000000007) * (arr[right] % 1000000007)) % 1000000007;
			right--;
		}
		left /= 2;
		right /= 2;
	}
	return res;
}