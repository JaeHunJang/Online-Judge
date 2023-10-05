import java.math.*;

class Solution {
    public int solution(int a, int b) {
        BigInteger bi = new BigInteger(b+"");
        int gcd = bi.gcd(new BigInteger(a+"")).intValue();
        
        b /= gcd;
        
        for(int i = 2; i < b; i++){
            bi = new BigInteger(i + "");
            if(bi.isProbablePrime(50) && b % i == 0 && i != 2 && i != 5) return 2;
        }
        
        return b == 1 || a == b || (b % 2 == 0 || b % 5 == 0) ? 1 : 2;
    }
}