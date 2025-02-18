import java.util.*;

class Solution {
    class Key {
        int num, cnt;
        Key (int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
        public String toString() {
            return "num: " + num + ", cnt: "+ cnt;
        }
    }
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<String, Key> map = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                String ch = keymap[i].charAt(j) + "";
                Key prev = map.getOrDefault(ch, new Key(Integer.MAX_VALUE,Integer.MAX_VALUE));
                Key now = new Key(i+1, j+1);
                if (Integer.compare(prev.cnt, now.cnt) > 0) {
                    map.put(ch, now);
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                String ch = targets[i].charAt(j) + "";
                if (!map.keySet().contains(ch)) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.get(ch).cnt;
            }
        }
        
        return answer;
    }
}