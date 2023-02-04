#include <bits/stdc++.h>

using namespace std;
vector<pair<float, int>> res;
bool comp(pair<float, int> v1, pair<float, int> v2){
	if(v1.first == v2.first){
		return v1.second < v2.second;
	}
	else return v1.first > v2.first;
}
vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<int> v(N+2);
    vector<int> temp(N+2);
    for(int i : stages){
        for(int j = 1; j <= i; j++){
            v[j]++;
        }
        temp[i]++;
    }
    
    for(int i =1 ;i <= N; i++){
        float f;
        if(v[i]==0) f = 0; 
    	else f = (float)temp[i]/v[i];
    	res.push_back({f, i});
	}
	sort(res.begin(), res.end(), comp);
	for(auto x : res){
		answer.push_back(x.second);
	}
    return answer;
}