class Solution {
    public String solution(String bin1, String bin2) {
        return Integer.toString(Integer.sum(Integer.valueOf(bin1, 2), Integer.valueOf(bin2, 2)), 2); 
    }
}