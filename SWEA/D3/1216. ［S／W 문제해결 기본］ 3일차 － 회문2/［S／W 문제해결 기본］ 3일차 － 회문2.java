import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
			int size = 100;
			String[][] arr = new String[size][size];
			List<String> list = new ArrayList<>();
            
            for(int i = 0; i < size; i++) {
                arr[i] = sc.next().split("");
            }
            
            int answer = 1;
            for(int i = 0; i < size; i++) {
            	for(int j = 0; j < size; j++) {
            		StringBuilder sb = new StringBuilder();
            		StringBuilder row = new StringBuilder();
                	StringBuilder col = new StringBuilder();
            		for(int k = j; k < arr.length; k++) {
            			row.append(arr[i][k]);
            			col.append(arr[k][i]);
            			sb.setLength(0);
                		if (row.toString().startsWith(sb.append(row.substring(row.length()/2)).reverse().toString())) {
                			answer = Math.max(answer, row.length());
                		}
                		sb.setLength(0);
                		if (col.toString().startsWith(sb.append(col.substring(col.length()/2)).reverse().toString())) {
                			answer = Math.max(answer, col.length());
                		}
            		}
            	}
            }
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
}