class Solution {
    public int solution(int n) {
        int answer = 0;
        int s = 1;
        while(s < n){
            s *= 3; 
        }
        if(s != n){
            s /= 3;
        }
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            if(s > n){
                s /= 3;
                sb.append(0);
                continue;
            }
            else{
                if(s * 2 <= n){
                    n -= s * 2;
                    s /= 3;
                    sb.append(2);
                }
                else{
                    n -= s;
                    s /= 3;
                    sb.append(1);
                }
            }
        }
        if(s != 0){
            while(s > 0){
                sb.append(0);
                s /= 3;
            }
        }
        String res = sb.toString();
        System.out.println(res);
        for(int i = 0; i < res.length(); i++){
            // answer += (int)(Math.pow(3, i)) * (int)(res.charAt(i));
            int a = (int)(Math.pow(3, i));
            int b = (int)(res.charAt(i) - '0');
            answer += a * b;
        }
        return answer;
    }
}