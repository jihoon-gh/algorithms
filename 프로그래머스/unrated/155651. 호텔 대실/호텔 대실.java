class Solution {
    static int[] arr = new int[1450];
    public int solution(String[][] book_time) {
        int answer = 0;
    
        for(String[] sarr : book_time){
            String[] splits1 = sarr[0].split(":");
            Integer h1 = Integer.parseInt(splits1[0]);
            Integer m1 = Integer.parseInt(splits1[1]);
            int start = h1 * 60 + m1;
            
            String[] splits2 = sarr[1].split(":");
            Integer h2 = Integer.parseInt(splits2[0]);
            Integer m2 = Integer.parseInt(splits2[1]);
            int end = h2 * 60 + m2 + 10;
            
            add(start, end);
        }
        for(int i = 0; i < arr.length; i++){
            answer = Math.max(arr[i], answer);
        }
        return answer;
    }
    public static void add(int start, int end){
        for(int i = start; i < end; i++){
            arr[i]++;
        }
        return;
    }
}