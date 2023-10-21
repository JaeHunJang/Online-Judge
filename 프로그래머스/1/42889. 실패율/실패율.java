import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> map = new HashMap();

        for(int i = 1; i <= N+1; i++){ //스테이지만큼 미리 생성
            map.put(i, 0.0);
        }
        for(int i : stages){ //각 스테이지 잔존인원 확인
            map.put(i, map.get(i) + 1);
        }
        
        int tot = 0;
        for(int i = map.size(); i > 0; i--){
            tot += map.get(i);
            if(map.get(i) > 0) map.put(i, map.get(i) / tot);
        }
        map.remove(N+1); //끝까지 클리어한 데이터는 제거
        
        //실패율 내림차순 정렬
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
        
        int idx = 0;
        for (int key : keys) {
            answer[idx++] = key;
        }
        
        return answer;
    }
}