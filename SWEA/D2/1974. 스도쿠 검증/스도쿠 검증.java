import java.util.HashSet;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = 9;
			int[][] map = new int[n][n];

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			HashSet<Integer> row = new HashSet<>();
			HashSet<Integer> col = new HashSet<>();
			HashSet<Integer> square = new HashSet<>();
			int answer = 1;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					row.add(map[i][j]);
					col.add(map[j][i]);
				}
				if(col.size() != 9 || row.size() != 9) {
					answer = 0;
					break;
				}
				row.clear();
				col.clear();
			}

			if(answer == 1) {
				for(int i = 0; i < n; i+=3) {
					for(int j = 0; j < n; j+=3) {
						for(int k = i; k < i+3; k++) {
							for(int l = j; l < j+3; l++) {
								square.add(map[k][l]);
							}
						}
						if(square.size() != 9) {
							answer = 0;
							break;
						}
					}
					if(answer == 0) break;
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}