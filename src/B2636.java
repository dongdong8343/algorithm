import java.io.*;
import java.util.*;
import java.awt.Point;

public class B2636 {
	static int time = 0, ret = 0, m, n;
	static List<Point> li = new ArrayList<>();
	static int[][] a = new int[104][104];
	static int[][] v = new int[104][104];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(true) {
			time++;
			li = new ArrayList<>();

			go(0, 0);

			if(li.isEmpty()) break;

			ret = li.size();
			li.forEach(p -> a[p.y][p.x] = 0);
			v = new int[104][104];
		}

		System.out.println(time - 1);
		System.out.println(ret);
	}

	static void go(int y, int x) {
		if(a[y][x] == 1) {
			li.add(new Point(x, y));
			return;
		}

		for(int i = 0; i < 4; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny < 0 || nx < 0 || ny >= n || nx >= m || v[ny][nx] == 1) continue;

			v[ny][nx] = 1;
			go(ny, nx);
		}
	}


}