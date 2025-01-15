import java.util.*;
class Solution {
    List<Integer>[] edges;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        edges = new List[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        
        for (int[] e : edge) {
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }
        
        return bfs();
    }
    
    int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        boolean visited[] = new boolean[edges.length];
        visited[1] = true;
        
        int size = 0;
        while(!q.isEmpty()) {
            size = q.size();
            for (int s = 0; s < size; s++) {
                int now = q.poll();
                for (int next : edges[now]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        
        return size;
    }
}