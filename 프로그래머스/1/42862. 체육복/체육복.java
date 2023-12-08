import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] d = {-1, 1};
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int l : lost) {
            lostList.add(l);
        }
        for(int r : reserve) {
            if(lostList.contains(r)) {
                lostList.remove(Integer.valueOf(r));
            } else reserveList.add(r);
        }
        
        for(int r : reserveList) {
            for(int i = 0; i < d.length; i++) {
                int idx = lostList.indexOf(r + d[i]);
                if(idx != -1) {
                    lostList.remove(idx);
                    break;
                }
            }
        }
        
        return n - lostList.size();
    }
}