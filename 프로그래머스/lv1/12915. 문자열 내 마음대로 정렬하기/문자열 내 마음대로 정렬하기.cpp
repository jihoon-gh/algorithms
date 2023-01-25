#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int k;
bool comp(string s1, string s2);
vector<string> solution(vector<string> strings, int n) {
    k = n;
    sort(strings.begin(), strings.end(), comp);
    vector<string> answer = strings;
    return answer;
}
bool comp(string s1, string s2){
    if( s1[k] == s2[k]){
        return s1 < s2;
    }
    return s1[k] < s2[k];
}