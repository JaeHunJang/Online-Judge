import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq1 = new PriorityQueue();
        PriorityQueue<Integer> pq2 = new PriorityQueue(Collections.reverseOrder());
        
        for(String s : operations){
            int temp;
            
            if(s.contains("I")){
                temp = Integer.parseInt(s.replace("I ",""));
                
                pq1.add(temp);
                pq2.add(temp);
            }else {
                
                if("D -1".equals(s) && pq1.size() > 0) {
                    temp = pq1.poll();
                    pq2.remove(temp);
                }
                else if ("D 1".equals(s) && pq1.size() > 0){
                    temp = pq2.poll();
                    pq1.remove(temp);
                }
                
            }
        }
        if(pq1.size() > 0)
            return new int[] {pq2.poll(), pq1.poll()};
        else return new int[] {0, 0};
    }
}