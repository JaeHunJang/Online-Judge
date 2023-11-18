import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#" + test_case + " ");
            int n = 9;
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
			int answer = 1;
            for(int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>();
                for(int j = 0; j < n; j++) {
                    temp.add(arr[j][i]);
                }
                if(temp.stream().distinct().count() != 9) {
                    answer = 0;
                    if(answer == 0)
                    	break;
                }
                temp.clear();
                if(Arrays.stream(arr[i]).distinct().count() != 9) {
                    answer = 0;
                    if(answer == 0)
                    	break;
                }
            }
            for(int i = 0; i < 3; i++)
                for(int j = 0; j < 3; j++) {
                    if(!check(i*3,j*3,arr)) {
                        answer = 0;
                        if(answer == 0)
                            break;
                    }
                }
            System.out.println(answer);
		}
	}
    public static boolean check(int i, int j, int[][] arr) {
		List<Integer> temp = new ArrayList<>();
		for(int x = i; x < i + 3; x++) {
			for(int y = j; y < j + 3; y++) {
				temp.add(arr[x][y]);
			}
		}
		return temp.stream().distinct().count() == 9;
	}
}