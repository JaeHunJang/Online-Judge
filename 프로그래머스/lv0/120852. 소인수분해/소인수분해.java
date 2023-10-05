import java.util.*;
import java.math.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList();
        for(int i = 2; n > 1;){
            if(n % i == 0) {
                if(list.indexOf(i) < 0)
                    list.add(i);
                n /= i;
            } else i++;
        }
        
        answer = new int[list.size()];
        int j = 0;
        for(int i : list){
            answer[j++] = i;
        }
        
//         ArrayList<Integer> list1 = new ArrayList();
//         ArrayList<Integer> list2 = new ArrayList();
//         BigInteger bigInt = BigInteger.ONE;
        
//         while(bigInt.intValue() <= n){
//             bigInt = bigInt.nextProbablePrime();
//             list1.add(bigInt.intValue());
//         }
        
//         while(n > 1){
//             for(int i : list1){
//                 if(n % i == 0) {
//                     if(list2.indexOf(i) < 0)
//                         list2.add(i);
//                     n /= i;
//                     break;
//                 }
//             }
//         }
        
//         answer = new int[list2.size()];
//         int j = 0;
//         for(int i : list2){
//             answer[j++] = i;
//         }
        
        return answer;
    }
}