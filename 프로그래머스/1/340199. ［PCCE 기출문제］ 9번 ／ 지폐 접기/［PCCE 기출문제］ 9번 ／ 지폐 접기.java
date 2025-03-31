class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (!isPossible(bill[0], bill[1], wallet)) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        
        
        return answer;
    }
    
    boolean isPossible(int r, int c, int[] wallet) {
        return (wallet[0] >= r && wallet[1] >= c) || (wallet[1] >= r && wallet[0] >= c);
    }
}