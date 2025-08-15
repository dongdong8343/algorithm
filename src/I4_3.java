import java.io.*;
import java.util.*;

public class I4_3 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Integer, Integer> hs = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		int[] a = new int[100004];
		int l = 1;

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for(int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= n; i++) {
			hs.put(a[i], hs.getOrDefault(a[i], 0) + 1);

			if(i - l + 1 > m) {
				int cnt = hs.get(a[l]) - 1;
				if(cnt == 0) hs.remove(a[l++]);
				else hs.put(a[l++], cnt);
			}
			if(i - l + 1 == m) {
				sb.append(hs.size()).append(" ");
			}
		}

		System.out.println(sb);
	}
}