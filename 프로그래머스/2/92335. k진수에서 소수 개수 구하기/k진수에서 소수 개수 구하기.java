class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String num = Long.toString(n, k);
        // System.out.println(num);
        for (String number : num.split("0")) {
            
            if (number.length() > 0) {
                // System.out.println(number);
                if (isPrime(Long.parseLong(number))) answer++;
            }
        }
        
        return answer;
    }
    
    boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}