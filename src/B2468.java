import java.io.*;
import java.util.*;

public class B2468 {
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int[][] a = new int[104][104];
	static int[][] v = new int[104][104];
	static int ret = 0, max = Integer.MIN_VALUE, height, n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int t = Integer.parseInt(st.nextToken());
				a[i][j] = t;
				max = Math.max(max, t);
			}
		}

		for (height = 0; height < max; height++) {
			v = new int[104][104];
			int cnt = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (a[i][j] > height && v[i][j] == 0) {
						cnt++;
						dfs(i, j);
					}
				}
			}

			ret = Math.max(ret, cnt);
		}

		System.out.println(ret);
	}

	static void dfs(int y, int x) {
		v[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] <= height || v[ny][nx] != 0)
				continue;

			dfs(ny, nx);
		}
	}
}