import java.io.*;
import java.util.*;
import java.awt.Point;

public class B14502 {
	static List<Point> li = new ArrayList<>();
	static int[][] a = new int[12][12];
	static int[][] v = new int[12][12];
	static int[][] virus = new int[12][12];
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int n, m, ret = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 2) {
					li.add(new Point(j, i));
					virus[i][j] = temp;
				} else {
					a[i][j] = temp;
				}
			}
		}

		go(0, 0, 0);

		System.out.println(ret);
	}

	static void go(int cnt, int y, int x) {
		if(cnt == 3) {
			bfs();

			int count = 0;

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(a[i][j] == 0 && v[i][j] != 2) count++;
				}
			}

			ret = Math.max(ret, count);
			return;
		}

		for(int i = y; i < n; i++) {
			if(y != i) x = 0;
			for(int j = x; j < m; j++) {
				if(a[i][j] == 0 && virus[i][j] != 2) {
					a[i][j] = 1;
					go(cnt + 1, i, j + 1);
					a[i][j] = 0;
				}
			}
		}
	}

	static void bfs() {
		v = new int[12][12];

		Queue<Point> q = new LinkedList<>(li);

		li.forEach(p -> {
			v[p.y][p.x] = 2;
		});

		while(!q.isEmpty()) {
			Point p = q.poll();

			for(int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				if(ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == 1 || v[ny][nx] == 2) continue;

				q.add(new Point(nx, ny));
				v[ny][nx] = 2;
			}
		}
	}
}