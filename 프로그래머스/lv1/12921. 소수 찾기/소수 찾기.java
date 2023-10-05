import java.math.*;
class Solution {
    public int solution(int n) {
        int[] temp = new int[n+1];
        int answer = 0;
        
        for(int i = 2; i*i <= n; i++){
            if(temp[i] == 0){
                for(int j = i*i; j <= n; j += i){
                    temp[j] = 1;
                }
            }
        }
        for(int i = 2; i <= n; i++){
            if(temp[i] == 0)
                answer++;
        }
        
        // int answer = 1;
        // BigInteger bi = new BigInteger(2+"");
        // while(bi.nextProbablePrime().intValue() <= n){
        //     bi = bi.nextProbablePrime();
        //     answer++;
        // }
        
        return answer;
    }
}