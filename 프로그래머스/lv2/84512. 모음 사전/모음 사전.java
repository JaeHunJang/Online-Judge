import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        String[] dic = {"A", "E", "I", "O", "U"};
        
        ArrayList<String> list = new ArrayList();
        for(int i = 0; i < 5; i++){
            list.add(dic[i]);
            for(int j = 0; j < 5; j++){
                list.add(dic[i] + dic[j]);
                for(int k = 0; k < 5; k++){
                    list.add(dic[i] + dic[j] + dic[k]);
                    for(int l = 0; l < 5; l++){
                        list.add(dic[i] + dic[j] + dic[k] + dic[l]);
                        for(int n = 0; n < 5; n++){
                            list.add(dic[i] + dic[j] + dic[k] + dic[l] + dic[n]);
                        }
                    }
                }
            }
        }
        
        // int answer = 0, per = 3905; //per : 조합의 경우의 수
        // for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        // return answer;
        
        return list.indexOf(word)+1;
    }
}