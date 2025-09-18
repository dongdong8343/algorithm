import java.io.*;
import java.util.*;

public class B2583 {
	static int n, m, k, ret = 0;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] a = new int[104][104];
	static int[][] v = new int[104][104];

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> li = new ArrayList<>();

		for(int i = 0; i < 100; i++) {
			Arrays.fill(a[i], 1);
		}

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for(int l = 0; l < k; l++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for(int i = y1; i < y2; i++) {
				for(int j = x1; j < x2; j++) {
					a[i][j] = 0;
				}
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(v[i][j] == 0 && a[i][j] == 1) {
					ret++;
					li.add(dfs(i, j));
				}
			}
		}

		Collections.sort(li);
		sb.append(ret).append("\n");
		li.forEach(t -> sb.append(t).append(" "));

		System.out.println(sb);

	}

	static int dfs(int y, int x) {
		int num = 1;
		v[y][x] = 1;

		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny < 0 || nx < 0 || ny >= n || nx >= m || v[ny][nx] == 1 || a[ny][nx] == 0) continue;

			num += dfs(ny, nx);
		}

		return num;
	}
}