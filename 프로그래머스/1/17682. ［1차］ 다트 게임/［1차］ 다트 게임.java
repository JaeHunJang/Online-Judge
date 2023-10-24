class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String score = "SDT";
        String option = "*#";
        String num = "";
        int[] scores = new int[3];
        int idx = 0;
        String[] darts = dartResult.split("");
        for(int i = 0; i < darts.length; i++){
            
            if(!score.contains(darts[i]) && !option.contains(darts[i])){
                num += darts[i];
            } else {
                if(!num.equals("")) {
                    scores[idx] = Integer.parseInt(num);
                    num = "";
                    scores[idx] = (int)Math.pow(scores[idx], score.indexOf(darts[i]) + 1);
                }
                if(i+1 < darts.length && option.contains(darts[i+1])) {
                    if(option.indexOf(darts[++i]) == 0) {
                        if(idx - 1 >= 0)
                            scores[idx - 1] *= 2;
                        scores[idx] *= 2;
                    } else if (option.indexOf(darts[i]) == 1) {
                        scores[idx] *= -1;
                    }
                }
                idx++;
            }
        }
        
        for(int n : scores){
            answer += n;
        }
        
        return answer;
    }
}