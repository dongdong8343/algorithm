import java.io.*;
import java.util.*;

public class B16234 {
	static int n, l, r, day = 0, cnt = 0;
	static boolean flag = false;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int[][] map = new int[54][54];
	static int[][] visited = new int[54][54];
	static int[][] area = new int[54][54];

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(true) {
			cnt = 0;
			visited = new int[54][54];
			area = new int[54][54];

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(visited[i][j] == 0) {
						cnt++;
						flag = false;
						dfs(i, j);
						if(!flag) cnt--;
					}
				}
			}

			if(cnt == 0) break;


			int[] ret = new int[cnt + 1];
			int[] num = new int[cnt + 1];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					ret[area[i][j]] += map[i][j];
					num[area[i][j]]++;
				}
			}

			for(int i = 1; i <= cnt; i++) {
				ret[i] /= num[i];
			}

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(area[i][j] != 0) {
						map[i][j] = ret[area[i][j]];
					}
				}
			}

			day++;
		}

		System.out.println(day);
	}

	static void dfs(int y, int x) {
		visited[y][x] = 1;

		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] == 1) continue;

			int temp = Math.abs(map[y][x] - map[ny][nx]);

			if(l <= temp && temp <= r) {
				flag = true;
				area[y][x] = cnt;
				area[ny][nx] = cnt;
				dfs(ny, nx);
			}
		}
	}
}