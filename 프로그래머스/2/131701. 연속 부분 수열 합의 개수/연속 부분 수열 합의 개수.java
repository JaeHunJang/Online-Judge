import java.util.*;

class Solution {
    class Seq {
        int idx, total;
        Seq(int idx, int total) {
            this.idx = idx;
            this.total = total;
        }
    }
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        Queue<Seq> q = new ArrayDeque<>();
        for (int i = 0; i < elements.length; i++) {
            q.offer(new Seq(i, elements[i]));
            set.add(elements[i]);
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            if (cnt == elements.length-1) break;
            for (int s = 0; s < size; s++) {
                Seq now = q.poll();
                now.total += elements[++now.idx % elements.length];
                set.add(now.total);
                q.offer(now);
            }
            cnt++;
        }
        int answer = set.size();
        return answer;
    }
}