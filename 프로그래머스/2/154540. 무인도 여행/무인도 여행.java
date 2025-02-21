import java.util.*;
class Solution {
    boolean visited[][];
    int deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    answer.add(bfs(maps, i, j));
                }
            }
        }
        if (answer.size() == 0) {
            return new int[] {-1};
        }
        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    
    int bfs(String[] maps, int r, int c) {
        visited[r][c] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r,c});
        int sum = maps[r].charAt(c) - '0';
        while(!q.isEmpty()) {
            int now[] = q.poll();
            
            for (int d = 0; d < deltas.length; ++d) {
                int nr = deltas[d][0] + now[0];
                int nc = deltas[d][1] + now[1];
                
                if (nr < 0 || nc < 0 || nr >= visited.length || nc >= visited[0].length || visited[nr][nc] || maps[nr].charAt(nc) == 'X') continue;
                visited[nr][nc] = true;
                sum += maps[nr].charAt(nc) - '0';
                q.offer(new int[] {nr, nc});
            }
        }
        
        return sum;
    }
}