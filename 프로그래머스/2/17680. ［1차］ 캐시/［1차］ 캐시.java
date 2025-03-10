import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> cache = new LinkedList<>();
        for (int i = 0; i < cities.length; ++i) {
            String conv = cities[i].toLowerCase();
            if (cache.contains(conv)) {
                cache.remove(conv);
                cache.add(conv);
                answer++;
            } else {
                if (cache.size() < cacheSize) {
                    cache.add(conv);
                } else {
                    if (!cache.isEmpty()) {
                        cache.remove(0);
                    }
                    if (cache.size() < cacheSize) {
                        cache.add(conv);
                    }
                }
                answer+=5;
            }
        }
        return answer;
    }
}