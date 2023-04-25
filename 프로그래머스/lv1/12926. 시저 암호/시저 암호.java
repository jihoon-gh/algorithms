class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] carr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(char c : carr){
            if(c == ' '){
                sb.append(c);
                continue;
            }
            if(c >= 97){
                int k = c - 97;
                k = (k + n) % 26;
                c = (char)(k + 97);
            }
            else{
                int k = c - 65;
                k = (k + n) % 26;
                c = (char)(k + 65);
            }
            sb.append(c);
        }
        answer = sb.toString();
        return answer;
    }
}