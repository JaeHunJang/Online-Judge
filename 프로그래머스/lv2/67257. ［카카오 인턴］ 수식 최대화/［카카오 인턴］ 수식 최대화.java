import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        
        String[][] operators = { //우선순위
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*-+".split(""),
            "*+-".split("")
        };
        
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true); //수식 분리
        ArrayList<String> tokens = new ArrayList();
        while(tokenizer.hasMoreTokens()){
            tokens.add(tokenizer.nextToken());
        }
        
        for(String[] op : operators){
            long result = Math.abs(calc(new ArrayList(tokens), op)); //계산 (리스트 복제)
            if(result > answer) answer = result;
        }
        
        return answer;
    }
    private long calc(ArrayList<String> tokens, String[] operators){
        for(String op : operators){
            for(int i = 0; i < tokens.size(); i++){
                if(tokens.get(i).equals(op)) {
                    long a = Long.parseLong(tokens.get(i-1));
                    long b = Long.parseLong(tokens.get(i+1));
                    long result = calc(a, b, op);
                    tokens.remove(i-1); //수식 A op B 만큼 제거
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1, String.valueOf(result)); //제거한 자리에 수식 결과 삽입
                    i -= 2; //인덱스 조정
                }
            }
        }
        return Long.parseLong(tokens.get(0)); //마지막 수식 결과 반환
    }
    private long calc(long a, long b, String op){
        return switch(op){
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                default -> 0;
        };
    }
}