import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int[][] arr90 = rotate(arr);
			int[][] arr180 = rotate(arr90);
			int[][] arr270 = rotate(arr180);
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					sb.append(arr90[i][j]);
				}
				sb.append(" ");
				for(int j = 0; j < n; j++) {
					sb.append(arr180[i][j]);			
				}
				sb.append(" ");
				for(int j = 0; j < n; j++) {
					sb.append(arr270[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.print("#" + test_case + "\n" + sb.toString());
		}
	}
	static int[][] rotate(int[][] arr) {
        int n = arr.length;
        int[][] rotate = new int[n][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[n-1-j][i];
            }
        }

        return rotate;
    }
}