import java.io.*;
import java.util.*;

public class I4_5 {
	static int n, m;
	static int[] a = new int[104];
	static List<Integer> sums = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		go(0, 0, 0);

		TreeSet<Integer> uniqDesc = new TreeSet<>(Collections.reverseOrder());
		uniqDesc.addAll(sums);

		if (uniqDesc.size() < m) {
			System.out.println(-1);
			return;
		}

		int k = 1;
		for (int val : uniqDesc) {
			if (k == m) {
				System.out.println(val);
				break;
			}
			k++;
		}
	}

	static void go(int idx, int cnt, int sum) {
		if (cnt > 3) return;
		if (idx > n) return;
		if (idx == n) {
			if (cnt == 3) sums.add(sum);
			return;
		}
		if (n - idx < 3 - cnt) return;

		go(idx + 1, cnt + 1, sum + a[idx]);
		go(idx + 1, cnt, sum);
	}
}
