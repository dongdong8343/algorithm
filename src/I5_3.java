import java.io.*;
import java.util.*;

public class I5_3 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();
		int[][] a = new int[104][104];

		int cnt = 0, n, m;

		n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		m = Integer.parseInt(br.readLine());
		int[] moves = new int[m];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			moves[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		for(int t : moves) {
			for(int i = 0; i < n; i++) {
				if(a[i][t] != 0) {
					if(!stack.isEmpty() && stack.peek() == a[i][t]) {
						stack.pop();
						cnt += 2;
					}
					else {
						stack.push(a[i][t]);
					}
					a[i][t] = 0;
					break;
				}
			}
		}

		System.out.println(cnt);

	}
}