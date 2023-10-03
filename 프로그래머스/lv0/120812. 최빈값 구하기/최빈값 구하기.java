import java.util.*;
import java.util.Collections;
class Solution {
    public int solution(int[] array) {
        int answer = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int n : array){
            if(!map.containsKey(n)){
                map.put(n, 1);
            } else {
                map.put(n, map.get(n)+1);
            }
        }
        
        List<Integer> keyset = new ArrayList<>(map.keySet());
        
        keyset.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });
        
        int prev = 0;
        for(int key : keyset){        
            if(map.get(key) > prev) {
                answer = key;
                prev = map.get(key);
                map.remove(key);
            } else {
                answer = -1;
            }
        }
        
        return answer;
    }
}