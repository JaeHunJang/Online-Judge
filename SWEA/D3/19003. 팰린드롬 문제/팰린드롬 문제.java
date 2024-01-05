import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
	static int max = 0;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			max = 0;
			int n = sc.nextInt(); 
            int m = sc.nextInt();
			String[] arr = new String[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.next();
			}
			
            for(int i = 0; i < n; i++) {
                max = Math.max(max, checkPalindrome(arr[i]));
            }
            
            int len = 0;
            List<String> list;
            for(int i = 0; i < n; i++) {
                list = Arrays.asList(arr);
                String reverse = new StringBuilder(arr[i]).reverse().toString();
                if (arr[i].length() != 0 && checkPalindrome(arr[i]) == 0 && Arrays.asList(arr).contains(reverse)) {
                	len += m * 2;
                    arr[i] = "";
                    arr[Arrays.asList(arr).indexOf(reverse)] = "";
                }
            }
            
			System.out.println("#" + test_case + " " + (len + max));
		}
	}
    static int checkPalindrome(String temp) {
        return temp.endsWith(new StringBuilder(temp.substring(0, temp.length()/2+1)).reverse().toString())? temp.length() : 0;
    }
}