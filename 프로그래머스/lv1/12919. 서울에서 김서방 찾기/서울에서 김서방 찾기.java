class Solution {
    public String solution(String[] seoul) {
        int res = -1;
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                res = i;
            }
        }
        return "김서방은 "+res+"에 있다";
    }
}