import java.util.*;
class Solution {
    class Pos {
        int r, c, dist;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
            dist = 0;
        }
    }
    Pos start, end;
    int[][] map;
    int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[101][101];
        start = new Pos(characterX * 2, characterY * 2);
        end = new Pos(itemX * 2, itemY * 2);
        
        int k = 1;
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2, x2 = rect[2] * 2, y2 = rect[3] * 2;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = k;
                }
            }
            k++;
        }
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2, x2 = rect[2] * 2, y2 = rect[3] * 2;
            for (int i = x1+1; i < x2; i++) {
                for (int j = y1+1; j < y2; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        return bfs() / 2;
    }
    
    int bfs () {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(start);
        boolean[][] visited = new boolean[102][102];
        visited[start.r][start.c] = true;
        
        while(!q.isEmpty()) {
            Pos now = q.poll();
            
            if (now.r == end.r && now.c == end.c) {
                return now.dist;
            }
            
            for (int d = 0; d < deltas.length; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];
                if (nr < 1 || nc < 1 || nr > 100 || nc > 100 || visited[nr][nc] || map[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                Pos next = new Pos(nr, nc);
                next.dist = now.dist + 1;
                q.offer(next);
            }
        }
        
        return -1;
    }
}