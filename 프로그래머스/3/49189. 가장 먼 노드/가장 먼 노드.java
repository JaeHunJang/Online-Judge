import java.util.*;

class Solution {
    List<Integer> list[];
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        list = new List[n+1];
        for (int i = 0; i < edge.length; i++) {
            if (list[edge[i][0]] == null) list[edge[i][0]] = new ArrayList();
            list[edge[i][0]].add(edge[i][1]);
            
            if (list[edge[i][1]] == null) list[edge[i][1]] = new ArrayList();
            list[edge[i][1]].add(edge[i][0]);
        }
        
        
        return bfs(n);
    }
    
    public int bfs(int n) {
        Queue<Integer> q = new ArrayDeque();
        q.offer(1);
        boolean visited[] = new boolean[n+1];
        visited[1] = true;
        
        int cnt = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            cnt = 0;
            for (int s = 0; s < size; s++) {
                int now = q.poll();
                cnt++;
                
                if (list[now] == null) continue;
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