import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        
        str1 = str1.toLowerCase();
        for (int i = 1; i < str1.length(); i++) {
            String key = str1.charAt(i-1) + "" + str1.charAt(i);
            if (Character.isAlphabetic(key.charAt(0)) && Character.isAlphabetic(key.charAt(1))) {
                map1.put(key, map1.getOrDefault(key, 0) + 1);
            }
        }
        
        str2 = str2.toLowerCase();
        for (int i = 1; i < str2.length(); i++) {
            String key = str2.charAt(i-1) + "" + str2.charAt(i);
            if (Character.isAlphabetic(key.charAt(0)) && Character.isAlphabetic(key.charAt(1))) {
                map2.put(key, map2.getOrDefault(key, 0) + 1);
            }
        }
        
        double joinCnt = 0;
        for (String k : map1.keySet()) {
            if (map2.keySet().contains(k)) {
                joinCnt += Math.min(map1.get(k), map2.get(k));
            }
        }
        
        double sumCnt = 0;
        Set<String> allKey = new HashSet();
        allKey.addAll(map1.keySet());
        allKey.addAll(map2.keySet());
        for (String k : allKey) {
            sumCnt += Math.max(map1.getOrDefault(k, 0), map2.getOrDefault(k, 0));
        }
        
        if (joinCnt == 0 && sumCnt == 0) return 65536;
        
        return (int) (joinCnt / sumCnt * 65536);
    }
}