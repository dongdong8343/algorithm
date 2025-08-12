import java.io.*;
import java.util.*;

public class I2_12 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int ret = 0;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] a = new int[m + 4][n + 4];

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				int t = Integer.parseInt(st.nextToken());
				a[i][j] = t;
			}
		}

		for(int i = 1; i <= n; i++) {
 			for(int j = 1; j <= n; j++) {
				 int cnt = 0;
				 for(int k = 0; k < m; k++) {
					 int pi = 0, pj = 0;
					 for(int s = 0; s < n; s++) {
						 if(a[k][s] == i) pi = s;
						 if(a[k][s] == j) pj = s;
					 }
					 if(pi < pj) cnt++;
				 }
				 if(cnt == m) ret++;
			}
		}

		System.out.println(ret);
	}
}