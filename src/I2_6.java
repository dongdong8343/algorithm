import java.io.*;
import java.util.*;

public class I2_6 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] a = new boolean[100004];

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		a[1] = true;
		for(int i = 2; i <= 100000; i++) {
			if(a[i]) {
				continue;
			}
			for(int j = i * 2; j <= 100000; j += i) {
				a[j] = true;
			}
		}

		for(int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();

			int t = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(sb.append(t).reverse().toString());

			if(!a[num]) {
				System.out.print(num + " ");
			}
		}
	}
}