import java.io.*;
import java.util.*;

public class I2_4 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[50];

		a[0] = 1;
		a[1] = 1;

		sb.append(a[0]).append(" ").append(a[1]).append(" ");

		for(int i = 2; i < n; i++) {
			a[i] = a[i - 1] + a[i - 2];
			sb.append(a[i]).append(" ");
		}

		System.out.println(sb);
	}
}
