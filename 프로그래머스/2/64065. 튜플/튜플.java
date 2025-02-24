import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.replace("{", "").replace("}", "");
        for (String ch : s.split(",")) {
            if (map.keySet().contains(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                if (isDigit(ch)) {
                    map.put(ch, 1);
                }
            }
        }
        
        List<String> keySet = new ArrayList<>();
        for (String key : map.keySet()) {
            keySet.add(key);
        }
        Collections.sort(keySet, (o1, o2) -> Integer.compare(map.get(o2+""), map.get(o1+"")));
        
        return keySet.stream().mapToInt(Integer::parseInt).toArray();
    }
    
    boolean isDigit(String n) {
        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            if(num < 0 && num > 9) return false;
        }
        return true;
    }
}