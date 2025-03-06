import java.util.*;

class Solution {
    class Pos {
        int r, c;
        String his;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
            this.his = "";
        }
        
        public String toString() {
            return his;
        }
    }
    final String dir = "dlru";
    final int[][] deltas = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";
        
        //PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o1.his.compareTo(o2.his));
        Pos end = new Pos(r, c);
        Queue<Pos> pq = new ArrayDeque<>();
        int cnt = 0;
        pq.offer(new Pos(x, y));
        
        while (cnt < k && !pq.isEmpty()) { 
            int size = pq.size();
            for (int s = 0; s < size; ++s) {
                Pos now = pq.poll();
                
                for (int d = 0; d < deltas.length; ++d) {
                    int nr = now.r + deltas[d][0];
                    int nc = now.c + deltas[d][1];

                    if (nr < 1 || nr > n || nc < 1 || nc > m) continue;
                    Pos next = new Pos(nr, nc);
                    if (!isIn(next, end, k-cnt)) continue;
                    next.his = now.his + dir.charAt(d);
                    if (nr == end.r && nc == end.c && cnt == k-1) return next.his;
                    pq.offer(next);
                    break;
                }
            }
            cnt++;
        }
        
        return answer;
    }
    
    boolean isIn(Pos o1, Pos o2, int dist) {
        if (convDist(o1, o2) > dist) return false;
        return true;
    }
    
    int convDist(Pos o1, Pos o2) {
        return Math.abs(o1.r - o2.r) + Math.abs(o1.c - o2.c);
    }
}