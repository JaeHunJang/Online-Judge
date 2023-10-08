import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> c1 = new LinkedList();
        Queue<String> c2 = new LinkedList();
        
        for(String card : cards1){
            c1.add(card);
        }
        for(String card : cards2){
            c2.add(card);
        }
        
        
        for (int i = 0; i < goal.length; i++){
            if(!c1.isEmpty() && c1.peek().equals(goal[i])) c1.poll();
            else if(!c2.isEmpty() && c2.peek().equals(goal[i])) c2.poll();
            else return "No";
            
        }      
        
        return "Yes";
    }
}