import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> q = new ArrayDeque<>();
        Stack<Integer> s = new Stack<>();
        int answer = 0;
        
        for (int i = 0; i < order.length; i++) {
            q.offer(i+1);
        }
        int i = 0;
        while (!q.isEmpty()) {
            while(s.size() != 0 && s.peek() == order[i]) {
                answer++;
                s.pop();
                i++;
            }
            if (q.peek() == order[i]) {
                answer++;
                q.poll();
                i++;
            } else {
                s.push(q.poll());
            }
            //System.out.println("i: " + i);
            //System.out.println("Q: " + q);
            //System.out.println("S: " + s);
        }
        
        while (!s.isEmpty() && s.peek() == order[i]) {
            answer++;
            i++;
            s.pop();
        }
        
        return answer;
    }
}