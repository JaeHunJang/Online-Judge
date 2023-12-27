import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String m = st.nextToken();
			String[] arr = new String[n];
			Queue<String[]> q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[j] = st.nextToken();
				q.add(new String[] {j+"", arr[j]});
			}
			Arrays.sort(arr, Collections.reverseOrder());
			int idx = 0;
			
			while(!q.isEmpty()) {
				if (!q.peek()[1].equals(arr[idx])) {
					q.add(q.poll());
				} else {
					idx++;
					if (q.poll()[0].equals(m)) {
						break;						
					}
				}
			}
			System.out.println(idx);
		}
	}
}