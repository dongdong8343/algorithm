import java.io.*;
import java.util.*;

public class I3_3 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] a = new int[100004];
		int sum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for(int i  = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < m; i++) {
			sum += a[i];
		}

		int t = sum;
		for(int i = m; i < n; i++) {
			t -= a[i - m];
			t += a[i];

			sum = Math.max(sum, t);
		}

		System.out.println(sum);
	}
}