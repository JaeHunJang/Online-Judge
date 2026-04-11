import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) nums[i] = numbers[i];
        Arrays.sort(nums, (o1, o2) -> {
            String n1 = o1+""+o2;
            String n2 = o2+""+o1;
            return n2.compareTo(n1);
        });
        
        // System.out.println(Arrays.toString(nums));
        StringBuilder sb = new StringBuilder();
        for (int n : nums) sb.append(n);
        if (sb.toString().startsWith("0")) return "0";
        return sb.toString();
    }
}