#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> food) {
    string answer = "";
    string s = "";
    for(int i=1;i<food.size();i++){
        string k = to_string(i);
        for(int j=0;j<food[i]/2;j++){
            s+=k;
        }
    }
    string s2 =s;
    reverse(s2.begin(),s2.end());
    answer=s+"0"+s2;
    return answer;
}