class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int i = 1;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        
        for(; i < max; i++){
            if (min + i > max)
                answer++;
        }
        for(; min + max > i; i++){
            answer++;
        }
        
        //answer += min * 2 - 1; //한줄로 완성

        // 반복문 1번 사용
        // for(int i=1; i<sides[0]+sides[1]; i++){
        //     if(i>max){
        //         if(min+max>i){
        //             answer++;
        //         }
        //     } else {
        //         if(min+i>max){
        //             answer++;
        //         }
        //     }
        // }
        
        return answer;
    }
}