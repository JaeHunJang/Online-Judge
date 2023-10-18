import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        ArrayList<int[]> list = new ArrayList();
        
        for(int i = 0; i < arr1.length; i++){
            int[] temp = new int[arr2[0].length];
            for(int j = 0; j < arr1[i].length; j++){
                for(int k = 0; k < arr2[0].length; k++){
                    temp[k] += arr1[i][j] * arr2[j][k];
                }
            }
            list.add(temp);
        }
        
        return list.toArray(new int[arr1.length][]);
    }
}