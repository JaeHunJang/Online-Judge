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
        
        /* //아이디어가 돋보이는 코드
        int answer = 0;
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        
        loop: while(true) { //이름붙은 반복문
            answer += max;
            for(int num : arr) {
                if(answer % num != 0) {
                    continue loop;
                }
            }
        return answer;
        */
        
        /* //간단하게 메소드를 정의하여 푼 코드
    public int solution(int[] arr) {
        int lcm = arr[0];

        for (int i = 0; i < arr.length; i++) {
            lcm = lcm(arr[i], lcm);
        }

        return lcm;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        int gcd = gcd(a,b);
        return gcd * (a / gcd) * (b / gcd);
    }
        */
    }
}