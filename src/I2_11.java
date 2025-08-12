import java.io.*;
import java.util.*;

public class I2_11 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] a = new int[1004][5];
		Set[] sets = new Set[1004];

		int max = Integer.MIN_VALUE, idx = 0;
		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			sets[i] = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int j = 0; j < 5; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 5; j++) {
				for(int k = i + 1; k < n; k++) {
					if(a[i][j] == a[k][j]) {
						sets[i].add(k);
						sets[k].add(i);
					}
				}
			}
		}

		for(int i = 0; i < n; i++) {
			if(max < sets[i].size()) {
				max = sets[i].size();
				idx = i + 1;
			}
		}

		System.out.println(idx);
	}
}
