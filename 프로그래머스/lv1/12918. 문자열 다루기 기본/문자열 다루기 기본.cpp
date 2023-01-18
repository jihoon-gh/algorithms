#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer;
    if(!(s.size()==4||s.size()==6)){
        return answer = false;
    }
    for(char c : s){
        if(c<48 || c > 57){
            return answer = false;
        }
    }
    return answer = true;
}