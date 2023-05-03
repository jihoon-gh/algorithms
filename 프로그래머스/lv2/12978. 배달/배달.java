import java.util.*;

class Solution {
    static class Pair{
        public int next;
        public int dist;
        public Pair(int a, int b){
            next = a;
            dist = b;
        }
    }
    static ArrayList<ArrayList<Pair>> plist = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dist = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 0; i <= N; i++){
            ArrayList<Pair> temp = new ArrayList<>();
            plist.add(temp);
        }
        for(int[] arr : road){
            int x = arr[0];
            int y = arr[1];
            int d = arr[2];
            plist.get(x).add(new Pair(y,d));
            plist.get(y).add(new Pair(x,d));
        }
        dijkstra(1, N);
        for(int i = 1; i<= N; i++){
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
    public static void dijkstra(int start, int n){
        for(int i = 0; i <= n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.dist - p2.dist;
            }
        });
        pq.add(new Pair(start, dist[start]));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(visited[p.next]) continue;
            visited[p.next] = true;
            for(Pair x : plist.get(p.next)){
                int b = x.next;
                int w = x.dist;
                if(dist[b] > w + dist[p.next]){
                    dist[b] = w + dist[p.next];
                    pq.add(new Pair(b, dist[b]));
                }
            }
        }
    }
}