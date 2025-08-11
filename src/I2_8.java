import java.io.*;
import java.util.*;

public class I2_8 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = new int[104];
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < n; i++) {
			int cnt = 1;

			for(int j = 0; j < n; j++) {
				if(a[i] < a[j]) {
					cnt++;
				}
			}

			sb.append(cnt).append(" ");
		}

		System.out.println(sb);
	}
}