import java.io.*;
import java.util.*;

public class B2559 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int sum = 0, l = 0, r = k, max;
		int[] a = new int[n + 4];

		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			int t = Integer.parseInt(st.nextToken());

			a[i] = t;

			if(i < k) sum += t;
		}

		max = sum;

		for(int i = k; i < n; i++) {
			sum = sum - a[l++] + a[r++];

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}