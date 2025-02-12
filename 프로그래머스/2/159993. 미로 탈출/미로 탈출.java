import java.util.*;

class Solution {
    class Pos {
        int r, c, lever;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
            lever = 0;
        }
    }
    char map[][];
    Pos start, end, lever;
    int deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(String[] maps) {        
        map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') start = new Pos(i,j);
                if (map[i][j] == 'E') end = new Pos(i,j);
                if (map[i][j] == 'L') end = new Pos(i,j);
            }
        }
        
        int answer = bfs(start, end);
        return answer;
    }
    
    int bfs (Pos s, Pos e) {
        boolean visited[][][] = new boolean[2][map.length][map[0].length];
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(s);
        visited[s.lever][s.r][s.c] = true;
        
        int time = 0;
        while(!q.isEmpty()) {
            int maxSize = q.size();
            for (int size = 0; size < maxSize; size++) {
                Pos now = q.poll();

                if (map[now.r][now.c] == 'E' && now.lever == 1) {
                    return time;
                }
                
                for (int d = 0; d < deltas.length; d++) {
                    int nr = now.r + deltas[d][0];
                    int nc = now.c + deltas[d][1];
                    
                    if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) continue;
                    if (visited[now.lever][nr][nc] || map[nr][nc] == 'X') continue;
                    visited[now.lever][nr][nc] = true;
                    Pos next = new Pos(nr, nc);
                    
                    if (map[nr][nc] == 'L') next.lever = 1;
                    else next.lever = now.lever;
                    q.offer(next);
                }
            }
            time++;
        }
        
        // for (int i = 0; i < visited.length; i++) {
        //     for (int j = 0; j < visited[i].length; j++) {
        //         System.out.println(Arrays.toString(visited[i][j]));
        //     }
        //     System.out.println();
        // }
        
        return -1;
    }
}