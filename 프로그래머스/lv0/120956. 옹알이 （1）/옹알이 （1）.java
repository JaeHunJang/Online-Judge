import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] temp = {"aya", "ye", "woo", "ma"};
        
        ArrayList<String> list = new ArrayList();
        for(String s1 : temp){
            list.add(s1);
            for(String s2 : temp){
                list.add(s1+s2);
                for(String s3 : temp){
                    list.add(s1+s2+s3);
                    for(String s4 : temp)
                        list.add(s1+s2+s3+s4);
                }
            }
        }
        
        for(String b : babbling){
            for(String s : list){
                if(b.equals(s)) answer++;
            }
        }
        
        return answer;
    }
}