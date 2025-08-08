import java.io.*;
import java.util.*;

public class I2_1 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = new int[104];
		int be = -1;
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < n; i++) {
			if(be < a[i]) {
				sb.append(a[i]).append(" ");
			}
			be = a[i];
		}

		System.out.println(sb);
	}
}