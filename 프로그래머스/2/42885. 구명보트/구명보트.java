import java.util.*;
import java.util.Collections;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Integer[] sort_people = new Integer[people.length];
        
        for(int i = 0; i < sort_people.length; i++){
            sort_people[i] = people[i];
        }
        
        Arrays.sort(sort_people, Collections.reverseOrder());
   
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int person : sort_people) {
            int calc = limit - person;
            if (pq.isEmpty()) {
                if (calc >= 40)
                    pq.add(limit - person);
                answer++;
            } else {
                if (pq.peek() >= person) {
                    pq.poll();
                } else {
                    if (calc >= 40)
                        pq.add(calc);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}