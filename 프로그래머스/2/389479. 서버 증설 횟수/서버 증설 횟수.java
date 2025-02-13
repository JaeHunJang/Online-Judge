import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> rent = new ArrayDeque<>();
        
        for (int i = 0; i < players.length; i++) {
            int size = rent.size();
            for (int s = 0; s < size; s++) {
                int server = rent.poll() - 1;
                if (server == 0) continue;
                rent.offer(server);
            }
            
            size = rent.size();
            if (players[i] > size * m) {
                while (!isIn(players[i], size, m)) {
                    rent.offer(k);
                    size = rent.size();
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    boolean isIn(int player, int server, int m) {
        return server * m <= player && player < (server+1) * m;
    }
}