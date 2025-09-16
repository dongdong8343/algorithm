import java.awt.*;
import java.io.*;
import java.util.*;

public class B2178 {
	static int[][] a = new int[104][104];
	static int[][] v = new int[104][104];
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int n, m;

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}

		v[0][0] = 1;

		go();

		System.out.println(v[n - 1][m - 1]);
	}

	static void go() {
		Queue<Point> q = new LinkedList<>();

		q.add(new Point(0, 0));

		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;

			if(y == n - 1 && x == m - 1) return;

			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >= m || v[ny][nx] != 0 || a[ny][nx] == 0) {
					continue;
				}
				v[ny][nx] = v[y][x] + 1;
				q.add(new Point(nx, ny));
			}
		}


	}
}