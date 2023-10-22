import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqAsc = new PriorityQueue();
        PriorityQueue<Integer> pqDesc = new PriorityQueue(Collections.reverseOrder());
        
        for(String s : operations){
            int temp;
            if(s.contains("I")){
                temp = Integer.parseInt(s.replace("I ",""));
                pqAsc.add(temp);
                pqDesc.add(temp);
            } else {
                if("D -1".equals(s) && pqAsc.size() > 0) {
                    temp = pqAsc.poll();
                    pqDesc.remove(temp);
                }
                else if ("D 1".equals(s) && pqAsc.size() > 0){
                    temp = pqDesc.poll();
                    pqAsc.remove(temp);
                }
            }
        }
        
        if(pqAsc.size() > 0)
            return new int[] {pqDesc.poll(), pqAsc.poll()};
        else 
            return new int[] {0, 0};
    }
}