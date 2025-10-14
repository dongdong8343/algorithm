import java.io.*;
import java.util.*;

public class B1325 {
	static List<Integer>[] com;
	static boolean[] v;
	static List<Integer> ret = new ArrayList<>();
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		com = new List[n + 1];
		v = new boolean[n + 1];

		for(int i = 1; i <= n; i++) {
			com[i] = new ArrayList<>();
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			com[b].add(a);
		}

		for(int i = 1; i <= n; i++) {
			v = new boolean[n + 1];

			int cnt = dfs(i);

			if(cnt >= max) {
				if(cnt > max) {
					ret = new ArrayList<>();
					max = cnt;
				}
				ret.add(i);
			}
		}

		Collections.sort(ret);

		ret.forEach(o -> sb.append(o).append(" "));

		System.out.println(sb);
	}

	static int dfs(int now) {
		v[now] = true;
		int cnt = 1;

		for (int t : com[now]) {
			if (v[t])
				continue;
			cnt += dfs(t);
		}

		return cnt;
	}
}