import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int work : works) pq.offer(work);
        
        for (int i = 0; i < n && !pq.isEmpty(); i++) {
            int work = pq.poll() - 1;
            if (work == 0) continue;
            pq.offer(work);
        }
        long answer = 0;
        
        while (!pq.isEmpty()) answer += (long)Math.pow(pq.poll(), 2);
        return answer;
    }
}