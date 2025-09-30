import java.io.*;
import java.util.*;
import java.awt.Point;

public class B10709 {
	static int[][] a = new int[104][104];
	static Queue<Point> q = new LinkedList<>();
	static int n, m;

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				if(s.charAt(j) == 'c') {
					a[i][j] = 1;
					q.add(new Point(j, i));
				}
			}
		}

		bfs();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(a[i][j] - 1).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			int nx = p.x + 1;

			if(nx >= m || a[p.y][nx] != 0) continue;

			a[p.y][nx] = a[p.y][p.x] + 1;

			q.add(new Point(nx, p.y));
		}
	}
}
