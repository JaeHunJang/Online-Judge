import java.util.*;

class Solution {
    List<Integer>[] list;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        list = new List[n+1];
        
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
        return bfs(n);
    }
    
    int bfs(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        
        int cnt = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            cnt = size;
            while (size-- > 0) {
                int now = q.poll();
                
                for (int next : list[now]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        
        return cnt;
    }
}