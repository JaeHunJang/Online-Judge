import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String name : participant){ //명단 제작
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion){ //완주자 조사
            map.put(name, map.get(name) - 1);
            if(map.get(name) == 0) map.remove(name);
        }
        
        return map.keySet().iterator().next(); //마지막 남은 사람 반환
        
    }
}