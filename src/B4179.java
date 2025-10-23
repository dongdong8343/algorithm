/**
 * 불과 지훈이가 동시에 이동할 칸이라면 지훈이는 가지 못한다.
 * 결국 불 먼저 이동시키고 지훈이가 이동하는 순서가 맞다.
 */

import java.io.*;
import java.util.*;
import java.awt.Point;

public class B4179 {
	static int ret = 0;
	static boolean escape = false, isMove;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int[][] map = new int[1004][1004];
	static Deque<Point> fq = new ArrayDeque<>();
	static Deque<Point> fq2 = new ArrayDeque<>();
	static Deque<Point> jq = new ArrayDeque<>();
	static Deque<Point> jq2 = new ArrayDeque<>();

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				char c = s.charAt(j);
				if(c == '#') map[i][j] = -1;
				else if(c == 'F') {
					map[i][j] = -2;
					fq.add(new Point(j, i));
				}
				else if(c == 'J') {
					map[i][j] = 1;
					jq.add(new Point(j, i));
				}
			}
		}

		while(true) {
			ret++;

			isMove = false;

			while(!fq.isEmpty()) {
				Point p = fq.poll();
				int y = p.y, x = p.x;

				for(int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if(ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == -1 || map[ny][nx] == -2) continue;
					if(map[ny][nx] > ret) continue;
					fq2.add(new Point(nx, ny));
					map[ny][nx] = -2;
				}
			}

			move:
			while(!jq.isEmpty()) {
				Point p = jq.poll();
				int x = p.x, y = p.y;

				for(int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
						escape = true;
						break move;
					}

					if(map[ny][nx] != 0) continue;
					map[ny][nx] = map[y][x] + 1;
					jq2.add(new Point(nx, ny));
					isMove = true;
				}
			}

			if(escape || !isMove) break;

			jq = jq2; fq = fq2;
			jq2 = new LinkedList<>();
			fq2 = new LinkedList<>();
		}

		System.out.println(escape ? ret : "IMPOSSIBLE");
	}
}