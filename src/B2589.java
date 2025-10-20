import java.io.*;
import java.util.*;
import java.awt.Point;

public class B2589 {
	static int n, m, ret = Integer.MIN_VALUE;
	static List<Point> li = new ArrayList<>();
	static int[][] a = new int[54][54];
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				char c = s.charAt(j);

				if(c == 'L') {
					a[i][j] = 1;
					li.add(new Point(j, i));
				}
			}
		}

		for(Point p : li) bfs(p);

		System.out.println(ret - 1);
	}

	static void bfs(Point s) {
		Deque<Point> q = new LinkedList<>();
		int[][] v = new int[54][54];

		q.add(s);
		v[s.y][s.x] = 1;

		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
				if(v[ny][nx] != 0) continue;
				if(a[ny][nx] == 0) continue;

				q.add(new Point(nx, ny));
				v[ny][nx] = v[p.y][p.x] + 1;

				ret = Math.max(ret, v[ny][nx]);
			}
		}
	}
}
