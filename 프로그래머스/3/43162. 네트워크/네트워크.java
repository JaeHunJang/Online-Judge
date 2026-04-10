import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        if (n == 0) return 1;
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (bfs(i, visited, computers) != 0) answer++;
        }
        
        return answer;
    }
    
    int bfs(int start, boolean[] visited, int[][] computers) {
        if (visited[start]) return 0;
        visited[start] = true;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        
        int cnt = 1;
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for (int i = 0; i < computers[now].length; i++) {
                if (i == now || visited[i]) continue;
                if (computers[now][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}