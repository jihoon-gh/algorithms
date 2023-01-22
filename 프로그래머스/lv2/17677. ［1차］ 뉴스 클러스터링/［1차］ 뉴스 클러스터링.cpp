#include <string>
#include <vector>
#include <regex>
#include <algorithm>
#include <iostream>
using namespace std;
bool checkValid(string s){
    regex re("[a-zA-Z]{2}");
    return regex_match(s,re);
}
vector<string> splitBy2(string s){
    vector<string> result;
    for(int i = 0; i < s.size()-1; i++){
        string temp = s.substr(i, 2);
        if(checkValid(temp)){
            if(temp[0] <=90) temp[0] += 32;
            if(temp[1] <=90) temp[1] += 32;
            result.push_back(temp);   
        }
    }
    return result;
}


int solution(string str1, string str2) {
    int answer = 0;
    vector<string> s1 = splitBy2(str1);
    vector<string> s2 = splitBy2(str2);
    
    sort(s1.begin(), s1.end());
    sort(s2.begin(), s2.end());
    
    
    vector<string> i(s1.size() + s2.size());
    auto iter2= set_intersection(s1.begin(), s1.end(), s2.begin(), s2.end(), i.begin());
    i.erase(iter2, i.end());
    
    vector<string> u(s1.size() + s2.size());
    auto iter1 = set_union(s1.begin(), s1.end(), s2.begin(), s2.end(), u.begin());
    u.erase(iter1, u.end());

    if(i.size()==0 && u.size() == 0){
        answer = 65536;
        return answer;
    }
    answer = (int)((float)i.size() / u.size() * 65536);
    return answer;
}