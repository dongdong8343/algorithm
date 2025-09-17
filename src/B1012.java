import java.io.*;
import java.util.*;

public class B1012 {
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int[][] a = new int[54][54];
	static int[][] v = new int[54][54];
	static int n, m;

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		while(tc-- > 0) {
			a = new int[54][54];
			v = new int[54][54];
			int ret = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				a[y][x] = 1;
			}

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(v[i][j] == 0 && a[i][j] == 1) {
						ret++;
						dfs(i, j);
					}
				}
			}

			sb.append(ret).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int y, int x) {
		v[y][x] = 1;

		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny < 0 || nx < 0 || ny >= n || nx >= m || v[ny][nx] != 0 || a[ny][nx] == 0) continue;

			dfs(ny, nx);
		}
	}
}