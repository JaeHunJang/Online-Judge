import java.util.*;
class Solution {
    class Position {
        int x;
        int y;
        int step;
        
        Position(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    
    public int solution(int[][] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        
        Queue<Position> q = new LinkedList();
        q.add(new Position(0, 0, 1));
        visit[0][0] = true;
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        while(!q.isEmpty()){
            Position p = q.poll();
            
            if(p.x == maps.length - 1 && p.y == maps[p.x].length - 1)
                return p.step;
            
            for(int i = 0; i < dx.length; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[nx].length)
                    continue;
                
                if(maps[nx][ny] == 0) continue;
                if(visit[nx][ny]) continue;
                
                q.add(new Position(nx, ny, p.step + 1));
                visit[nx][ny] = true;
            }
        }
        
        
        return -1;
    }
}