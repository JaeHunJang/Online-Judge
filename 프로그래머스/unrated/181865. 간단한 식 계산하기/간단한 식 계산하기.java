class Solution {
    public int solution(String binomial) {
        int answer = 0;
//         String temp = "";
        
//         for(char ch : binomial.toCharArray()){
//             if(ch == '+') { answer = 1; temp += ","; continue; }
//             if(ch == '-') { answer = 2; temp += ","; continue; }
//             if(ch == '*') { answer = 3; temp += ","; continue; }
//             if(Character.isDigit(ch)) temp += ch;
//         }
        
//         int a = Integer.parseInt(temp.split(",")[0]);
//         int b = Integer.parseInt(temp.split(",")[1]);
        
//         switch(answer){
//             case 1 : answer = a + b; break;
//             case 2 : answer = a - b; break;
//             case 3 : answer = a * b; break;
//         }
        
        int a = Integer.parseInt(binomial.split(" ")[0]);
        int b = Integer.parseInt(binomial.split(" ")[2]);
        
        switch(binomial.split(" ")[1]){
            case "+" : answer = a + b; break;
            case "-" : answer = a - b; break;
            case "*" : answer = a * b; break;
        }
        
        return answer;
    }
}