import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // float[] cnt = new float[N+1];
        Map<Integer, Double> map = new HashMap();

        for(int i = 1; i <= N+1; i++){ //스테이지만큼 미리 생성
            map.put(i, 0.0);
        }
        for(int i : stages){ //각 스테이지 잔존인원 확인
            map.put(i, map.get(i) + 1);
        }
        // System.out.println(Arrays.toString(cnt));
        
        int tot = 0;
        for(int i = map.size(); i > 0; i--){
            tot += map.get(i);
            if(map.get(i) > 0) map.put(i, map.get(i)/tot);
            // System.out.println(i + "|" + map.get(i)+"");
        }
        map.remove(N+1);
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
        
        int idx = 0;
        for (int key : keys) {
            answer[idx++] = key;
            // System.out.println(key+"|" + map.get(key));
        }
        
        
        
        // for(int i = cnt.size(); i >= 0; i--){
        //     tot += cnt.get(i[i];
        //     if(cnt[i] == 0) continue;
        //     cnt[i] = cnt[i] / tot;
        // }
        // for(int i = 0; i < cnt.length; i++){
        //     max = max < cnt[i] ? cnt[i] : max;
        // }
        // System.out.println(Arrays.toString(cnt));
        // System.out.println(max);
        
        return answer;
    }
}