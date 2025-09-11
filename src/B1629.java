import java.io.*;
import java.util.*;

public class B1629 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());

		System.out.println(go(a, b, c));
	}

	public static long go(long a, long b, long c) {
		if(b == 1) return a % c;

		long num = go(a, b / 2, c);
		num = (num * num) % c;

		if(b % 2 == 1) return (num * a) % c;

		return num;
	}
}