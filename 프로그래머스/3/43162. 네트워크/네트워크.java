import java.util.*;

class Solution {
    boolean[] visited;
    List<Integer>[] list;
    int answer = 0;
    public int solution(int n, int[][] computers) {
        
        
        list = new List[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    list[i].add(j);
                    if (list[j] == null) {
                        list[j] = new ArrayList();
                    }
                    list[j].add(i);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            bfs(i);
        }
        return answer;
    }
    
    void bfs(int start) {
        if (visited[start]) return;
        Queue<Integer> q = new ArrayDeque();
        q.offer(start);
        visited[start] = true;
        answer++;
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : list[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.offer(next);
            }
        }
    }
}