import java.io.*;
import java.util.*;

public class I2_9 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] a = new int[54][54];
		int sum = 0;

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < n; i++) {
			int t1 = 0, t2 = 0;
			for(int j = 0; j < n; j++) {
				t1 += a[i][j];
				t2 += a[j][i];
			}
			sum = Math.max(sum, t1);
			sum = Math.max(sum, t2);
		}

		int t1 = 0, t2 = 0;
		for(int i = 0; i < n; i++) {
			t1 += a[i][i];
			t2 += a[i][n - i - 1];
		}

		sum = Math.max(sum, t1);
		sum = Math.max(sum, t2);

		System.out.println(sum);
	}
}
