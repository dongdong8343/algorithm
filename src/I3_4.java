import java.io.*;
import java.util.*;

public class I3_4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = new int[100004];
		int l = 0, r = 0, sum = 0, ret = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		while (r < n) {
			if(sum < m) {
				sum += a[r++];
			}
			if (sum > m) {
				sum -= a[l++];
			}
			if (sum == m) {
				ret++;
				sum -= a[l++];
			}
		}

		while(l < n) {
			sum -= a[l++];
			if(sum == m) {
				ret++;
			}else if(sum < m) {
				break;
			}

			System.out.println(sum);
		}

		System.out.println(ret);
	}

}