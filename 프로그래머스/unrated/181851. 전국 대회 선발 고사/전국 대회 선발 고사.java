import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int idx = 0;
        int now_rank = 1;
        int[] students = new int[3];
        
        ArrayList al = new ArrayList();
        for(int i = 0; i < rank.length; i++){
            al.add(rank[i]);
        }
        
        for(int i = 0; i < al.size() && idx < 3; i++){
            if(attendance[al.indexOf(now_rank)]) {
                students[idx] = al.indexOf(now_rank);
                idx++;
                now_rank++;
            }
            else now_rank++;
        }
        
        return 10000 * students[0] + 100 * students[1] + students[2];
    }
}