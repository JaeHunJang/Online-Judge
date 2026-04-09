import java.util.*;

class Solution {
    final char[] alpha = {'a', 'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        int answer = 0;
        List<String> dic = new ArrayList<>();
        int i = 1, j = 1, k = 1, l = 1, n = 1;
        for (; i < alpha.length; i++) {
            dic.add(""+alpha[i]);
            for (j=1; j < alpha.length; j++) {
                dic.add(""+alpha[i] + alpha[j]);
                for (k=1; k < alpha.length; k++) {
                    dic.add(""+alpha[i] + alpha[j] + alpha[k]);
                    for (l=1; l < alpha.length; l++) {
                        dic.add(""+alpha[i] + alpha[j] + alpha[k] + alpha[l]);
                        for (n=1; n < alpha.length; n++) {
                            dic.add(""+alpha[i] + alpha[j] + alpha[k] + alpha[l] + alpha[n]);
                        }
                    }
                }
            }
        }
        
        return dic.indexOf(word)+1;
    }
}