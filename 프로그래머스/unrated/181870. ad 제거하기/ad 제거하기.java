class Solution {
    public String[] solution(String[] strArr) {
        String temp = "";
        for(int i = 0; i < strArr.length; i++){
            temp += !strArr[i].contains("ad") ? strArr[i] + "," : "";
        }
        
        return temp.split(",");
    }
}