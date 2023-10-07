import java.util.*;
class Solution {
    public class State {
        String word;
        int step;
        
        State(String word, int step){
            this.word = word;
            this.step = step;
        }
    }
    
    boolean isNext(String s1, String s2){
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        
        int diff = 0;
        for(int i = 0; i < ch1.length; i++){
            if(ch1[i] != ch2[i]) diff++;
        }
        
        return diff == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visit = new boolean[words.length];
        
        Queue<State> q = new LinkedList();
        q.add(new State(begin, 0));
        
        while(!q.isEmpty()){
            State state = q.poll();
            
            if(state.word.equals(target)) return state.step;
            
            for(int i = 0; i < words.length; i++){
                if(visit[i]) continue;
                if(isNext(words[i], state.word)) { 
                    q.add(new State(words[i], state.step + 1));
                    visit[i] = true;
                }
            }
        }
        
        return 0;
    }
}