class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        int[] parent = new int[27];
        char[] temp = skill.toCharArray();
        int before = 0;
        for(char c : temp){
            parent[c - 'A' + 1] = before;
            before = c - 'A' + 1;
        }
        
        for(String s : skill_trees){
            boolean[] tmp = new boolean[27];
            boolean isOk = true;
            char[] carr = s.toCharArray();
            for(char c : carr){
                int k = parent[c -'A' + 1];
                if(k != 0 && !tmp[k]){
                    isOk = false;
                    break;
                }
                tmp[c - 'A' + 1] = true;
            }
            if(isOk){
                answer++;
            }
        }
        return answer;
    }
}