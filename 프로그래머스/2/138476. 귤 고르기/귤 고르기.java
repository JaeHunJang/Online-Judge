import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap();
        
        for(int n : tangerine){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer> keySet = new ArrayList(map.keySet());
        
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        
        for(int n : keySet){
            if(k > 0) {
                k -= map.get(n);
                answer++;
            } else break;
        }
        
        return answer;
    }
}