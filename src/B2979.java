import java.io.*;
import java.util.*;

public class B2979 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] cost = new int[3];
		int[] a = new int[104];
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;

		for(int i = 0; i < 3; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			max = Math.max(e, max);
			min = Math.min(s, min);

			for(int j = s; j < e; j++) {
				a[j]++;
			}
		}

		for(int i = min; i < max; i++) {
			if(a[i] == 1) sum += cost[0];
			else if(a[i] == 2) sum += a[i] * cost[1];
			else sum += a[i] * cost[2];
		}

		System.out.println(sum);
	}
}