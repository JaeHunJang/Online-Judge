class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        // for(int i = 1; i < common.length; i++) {
        //     if(answer == 0) answer = common[i] - common[i-1];
        //     else if(common[i] - common[i-1] != answer) {
        //         answer = -1;
        //     }
        // }
        // if(answer == -1){
        //     answer = common[1] / common[0] * common[common.length-1];
        // } else answer += common[common.length-1];
        
        if(common[2] + common[0] == common[1] * 2){
            answer = (common[1] - common[0]) + common[common.length-1];
        } else answer = (common[1] / common[0]) * common[common.length-1];
        
        return answer;
    }
}