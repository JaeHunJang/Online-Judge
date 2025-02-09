import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer,Integer> older = new HashMap<>();
        Map<Integer,Integer> younger = new HashMap<>();
        
        older.put(topping[0], 1);
        for (int i = 1; i < topping.length; i++) {
            younger.put(topping[i], younger.getOrDefault(topping[i], 0) + 1);
        }
        
        
        if (older.size() == younger.size()) {
            answer++;
        }
        
        for (int i = 1; i < topping.length; i++) {
            older.put(topping[i], older.getOrDefault(topping[i], 0) + 1);
            younger.put(topping[i], younger.get(topping[i]) - 1);
            if (younger.get(topping[i]) == 0) {
                younger.remove(topping[i]);
            }
            
            if (older.size() == younger.size()) {
                answer++;
            }
        }
        
        
        
        
        return answer;
    }
}