import java.io.*;
import java.util.*;

public class I2_10 {
	static int cnt = 0, n;
	static int[][] a = new int[54][54];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args)throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(check(i, j)) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}

	static boolean check(int y, int x) {
		int temp = a[y][x];

		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
				continue;
			}

			if(a[ny][nx] >= temp) {
				return false;
			}
		}

		return true;
	}
}