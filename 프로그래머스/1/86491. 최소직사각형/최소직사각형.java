class Solution {
    public int solution(int[][] sizes) {
        int w = 0, h = 0;
        
        for (int[] size : sizes) {
            w = Math.max(Math.max(size[0],size[1]), w);
            h = Math.max(Math.min(size[0],size[1]), h);
        }
        
        return w * h;
    }
}