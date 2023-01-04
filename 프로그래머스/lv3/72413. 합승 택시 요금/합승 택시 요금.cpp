#include <string>
#include <vector>
#include <utility>
#include <queue>
#include <iostream>


using namespace std;

bool visited[201]={0};
int dist[201]={0};
int distStart[201] = {0};
vector<pair<int, int>> adj[201];
priority_queue<pair<int,int>> q;
void init();
void dijkstra(int, int);
int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    int answer = 1000000000;
    for(int i = 0; i < fares.size(); i++){
        adj[fares[i][0]].push_back({fares[i][1],fares[i][2]});
        adj[fares[i][1]].push_back({fares[i][0],fares[i][2]});
    }
    dijkstra(n, s);
    for(int i = 1; i <= n; i++){
        distStart[i] = dist[i];
    }
    
    int d = dist[a] + dist[b];
    for(int i =1; i <= n; i++){
        int k = distStart[i];
        init();
        dijkstra(n, i);
        if(dist[a]!=987654321&&dist[b]!=987654321){
            int temp = k + dist[a]+dist[b];
            answer = min(answer,temp);
        }
    }
    answer = min(d, answer);
    return answer;
}
void dijkstra(int n, int start){
    for(int i = 1; i <= n; i++){
        dist[i]=987654321;
    }
    dist[start]=0;
    q.push({0, start});
    while(!q.empty()){
        int a = q.top().second;
        q.pop();
        if(visited[a]) continue;
        visited[a]=true;
        for(auto x : adj[a]){
            int b = x.first;
            int w = x.second;
            if(dist[b]>dist[a]+w){
                dist[b]=dist[a]+w;
                q.push({-dist[b],b});
            }
        }
    }
}
void init(){
    for(int i = 0; i < 201; i++){
        visited[i]=false;
    }
}