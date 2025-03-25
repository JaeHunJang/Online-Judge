import java.util.*;

class Solution {
    ArrayDeque<Integer> hamburger;
    ArrayDeque<Integer> q;
    public int solution(int[] ingredient) {
        int answer = 0;
        
        hamburger = new ArrayDeque<>();
        
        for (int i = 0; i < ingredient.length; ++i) {
            hamburger.offer(ingredient[i]);
            
            while (isHamburger()) {
                ++answer;
            }
        }
        
        return answer;
    }
    
    boolean isHamburger() {
        int[] temp = new int[4];
        if (hamburger.size() >= 4) { // 햄버거 역순
            temp[0] = hamburger.pollLast(); // 1
            temp[1] = hamburger.pollLast(); // 3
            temp[2] = hamburger.pollLast(); // 2
            temp[3] = hamburger.pollLast(); // 1
            
            if (temp[0] == 1 && temp[1] == 3 && temp[2] == 2 && temp[3] == 1) {
                return true;
            } 
            
            for (int i = temp.length-1; i >= 0; --i) { // 원복
                hamburger.offer(temp[i]);
            }
        }
        
        return false;
    }
}