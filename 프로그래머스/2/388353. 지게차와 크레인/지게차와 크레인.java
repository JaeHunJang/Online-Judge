import java.util.*;

class Solution {
    class Pos {
        int r, c;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        public String toString() {
            return "r: " + r + ", c: "+ c;
        }
    }
    char warehouse[][];
    Map<Character, List<Pos>> index;
    int deltas[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    public int solution(String[] storage, String[] requests) {
        warehouse = new char[storage.length+2][storage[0].length()+2];
        index = new HashMap<>();
        for (int j = 1; j <= storage.length; j++) {
            for (int i = 1; i <= storage[j-1].length(); i++) {
                warehouse[j][i] = storage[j-1].charAt(i-1);
                List list = index.getOrDefault(warehouse[j][i], new ArrayList<>());
                list.add(new Pos(j, i));
                index.put(warehouse[j][i], list);
            }
        }
        
        for (String request : requests) {
            char marker = request.charAt(0);
            if (request.length() == 1) {
                bfs(marker);
            } else {
                allDelete(marker);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < warehouse.length; i++) {
            for (int j = 0; j < warehouse[i].length; j++) {
                if (warehouse[i][j] != '\0') answer++;
            }
        }
        
        return answer;
    }
    
    void bfs(char marker) {
        boolean visited[][] = new boolean[warehouse.length][warehouse[0].length];
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(0,0));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Pos now = q.poll();
            
            for (int d = 0; d < deltas.length; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];
                
                if (nr < 0 || nc < 0 || nr >= warehouse.length || nc >= warehouse[0].length || visited[nr][nc]) continue;
                
                if (warehouse[nr][nc] == '\0') {
                    visited[nr][nc] = true;
                    q.offer(new Pos(nr, nc));
                }
                
                if (warehouse[nr][nc] == marker) {
                    warehouse[nr][nc] = '\0';
                    visited[nr][nc] = true;
                } 
            }
        }
        
    }
    
    void allDelete(char marker) {
        if (!index.keySet().contains(marker)) return;
        for (Pos now : index.get(marker)) {
            warehouse[now.r][now.c] = '\0';
        }
    }
}