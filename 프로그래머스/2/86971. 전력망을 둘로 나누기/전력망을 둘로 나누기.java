import java.util.*;

class Solution {
    List<Integer>[] list;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        list = new List[n+1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];
            list[from].add(to);
            list[to].add(from);
        }
        
        
        answer = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            boolean[] visited = new boolean[n+1];
            int a = bfs(list, wire[0], wire[1], visited);
            int b = bfs(list, wire[1], wire[0], visited);
            answer = Math.min(answer, Math.abs(a - b));
        }
        
        return answer;
    }
    
    public int bfs(List<Integer>[] list, int start, int pass, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        
        int cnt = 1;
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for (int next : list[now]) {
                if (visited[next] || next == pass) continue;
                visited[next] = true;
                q.offer(next);
                cnt++;
            }
        }
        
        return cnt;
    }
}