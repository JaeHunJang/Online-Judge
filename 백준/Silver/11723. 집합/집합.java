import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[21];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if ("add".equals(command)) {
					arr[num] = 1;
				} else if ("remove".equals(command)) {
					arr[num] = 0;
				} else if ("check".equals(command)) {
					sb.append(arr[num] == 1 ? "1\n" : "0\n");
				} else if ("toggle".equals(command)) {
					if (arr[num] == 1) arr[num] = 0; 
					else arr[num] = 1;
				}
			} else {	
				if ("all".equals(command)) {
					for (int j = 1; j <= 20; j++)
						arr[j] = 1;
				} else {
					Arrays.fill(arr, 0);
				}
			}
		}
		System.out.print(sb.toString());
	}
}