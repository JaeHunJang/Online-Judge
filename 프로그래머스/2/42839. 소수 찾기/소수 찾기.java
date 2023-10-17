import java.util.*;
import java.math.*;
class Solution {
    private boolean compareNumber(int num, String numbers){
        boolean flag = false;
        char[] compareNums = (num+"").toCharArray();
        
        List<String> list = new ArrayList();
        
        for(String ch : numbers.split("")){
            list.add(ch);
        }
        
        
        for(char ch : compareNums){
            if(!list.remove(ch+"")) {
                return false;                
            } 
        }
            System.out.println(num + "|" + flag);
        
        return true;
        
    }
    public int solution(String numbers) {
        int answer = 0;
        
        char[] temp = numbers.toCharArray();
        Arrays.sort(temp);
        StringBuilder sb = new StringBuilder();
        sb.append(temp);
        Set<Integer> set = new HashSet();

        // System.out.println(sb.toString());
        
        
        int start = Integer.parseInt(temp[0] + "");
        int end = Integer.parseInt(sb.reverse().toString());
        
        BigInteger bi = new BigInteger(start + "");
        int now = start;
        for(int i = start; i <= end; i++){
            int max = (int)Math.sqrt(i);
            if(i < 2) continue;
            boolean flag = true;
            for(int j = 2; j <= max; j++){
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag && compareNumber(i, numbers)) answer++;
            
        }
//         while(now < end) {
//             bi = bi.nextProbablePrime();
//             now = bi.intValue();
//             set.add(now);
//             if(compareNumber(now, numbers)) answer++;
            
//         }
        // System.out.println(set.size()+"");
        
        return answer;
    }
}