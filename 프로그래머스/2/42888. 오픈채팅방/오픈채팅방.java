import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        Queue<String[]> q = new ArrayDeque<>();
        for (String r : record) {
            String[] msg = r.split(" ");
            String cmd = msg[0];
            String uid = msg[1];
            if (!"Leave".equals(cmd)) {
                String nick = msg[2];
                map.put(uid, nick);
            }
            if (!"Change".equals(cmd)) {
                q.offer(new String[]{cmd, uid});
            }
        }
        String[] answer = new String[q.size()];
        int i = 0;
        for (String[] r : q) {
            String cmd = r[0];
            String nick = map.get(r[1]);
            if ("Enter".equals(cmd)) {
                answer[i] = nick + "님이 들어왔습니다.";
            } else if ("Leave".equals(cmd)) {
                answer[i] = nick + "님이 나갔습니다.";
            }
            i++;
        }
        
        return answer;
    }
}