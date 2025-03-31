import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            answer[i] = players[i];
        }
        
        for (int i = 0; i < callings.length; i++) {
            int rank = map.get(callings[i]);
            map.put(callings[i], rank-1);
            map.put(answer[rank-1], rank);
            
            String swap = answer[rank-1];
            answer[rank-1] = answer[rank];
            answer[rank] = swap;            
        }
        
        return answer;
    }
}