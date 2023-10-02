import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int cnt = 0;
        boolean flag = true;
        
        Vector<String> v = new Vector();
        
        for(String s : want){
            v.add(s);
        }
        
        for(int i = 0; i < discount.length; i++){
            int[] temp = Arrays.copyOf(number, number.length);

            for(int j = i; j < discount.length && j < i+10; j++){
                if(v.indexOf(discount[j]) >= 0){
                    temp[v.indexOf(discount[j])]--;
                }
            }

            flag = true;
            for(int k = 0; k < temp.length; k++) {
                flag = temp[k] != 0 ? false : true;
                if(temp[k] == 0){
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                answer++;
            }
        }
        
        return answer;
    }
}