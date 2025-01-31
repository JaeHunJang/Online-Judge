import java.util.*;

class Solution {
    Map<String, Integer> totalCount;
    Map<String, Integer> count;
    
    public int solution(String[] friends, String[] gifts) {
        totalCount = new HashMap<>();
        count = new HashMap<>();
        for (String gift : gifts) {
            String give = gift.split(" ")[0];
            String receive = gift.split(" ")[1];
            totalCount.put(give, totalCount.getOrDefault(give, 0) + 1);
            totalCount.put(receive, totalCount.getOrDefault(receive, 0) - 1);
            count.put(gift, count.getOrDefault(gift, 0) + 1);
        }
        
        int answer = 0;
        for (int i = 0; i < friends.length; i++) {
            int cnt = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                int case1 = count.getOrDefault(friends[i] + " " + friends[j], 0);
                int case2 = count.getOrDefault(friends[j] + " " + friends[i], 0);
                if (case1 > case2) {
                    cnt++;
                } else if (case1 == case2) {
                    if (totalCount.getOrDefault(friends[i], 0) > totalCount.getOrDefault(friends[j], 0)) cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        
        
        return answer;
    }
}