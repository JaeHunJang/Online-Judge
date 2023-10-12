import java.util.*;
import java.math.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        Stack<Integer> q = new Stack();
        
        BigInteger lcm = new BigInteger("1");
        BigInteger num = new BigInteger(arr[0] + "");

        for(int n : arr){
            q.push(n);
        }
        
        while(q.size() > 2){
            BigInteger num1 = new BigInteger(q.pop()+"");
            BigInteger num2 = new BigInteger(q.pop()+"");
            q.push(num1.intValue() * num2.intValue() / num1.gcd(num2).intValue());
        }
        
        return q.pop();
    }
}