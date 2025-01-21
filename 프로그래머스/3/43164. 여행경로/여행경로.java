import java.util.*;
class Solution {
    String[] answer;
    Map<String, boolean[]> visited;
    Map<String, List<String>> map;
    boolean found;
    public String[] solution(String[][] tickets) {
        visited = new HashMap<>();
        map = new HashMap<>();
        found = false;
        
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            List<String> list = map.getOrDefault(start, new ArrayList<>());
            list.add(end);
            map.put(start, list);
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
            visited.put(key, new boolean[map.get(key).size()]);
        }
        
        answer = new String[tickets.length+1];
        answer[0] = "ICN";
        dfs("ICN", 1);
        
        return answer;
    }
    
    void dfs(String start, int cnt) {
        if (found) return;
        if (cnt == answer.length) {
            found = true;
            return;
        }
        
        if (!map.containsKey(start)) return;
        
        List<String> destinations = map.get(start);
        for (int i = 0; i < destinations.size(); i++) {
            if (visited.get(start)[i]) continue;
            
            String next = destinations.get(i);
            answer[cnt] = next;
            visited.get(start)[i] = true;
            dfs(next, cnt + 1);
            if (found) return;
            visited.get(start)[i] = false;
        }
    }
}