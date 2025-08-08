import java.io.*;
import java.util.*;

public class I2_3 {
	private static final int SCISSORS = 1;
	private static final int ROCK = 2;
	private static final int PAPER = 3;

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] a = new int[104];
		int[] b = new int[104];

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st1.nextToken());
			b[i] = Integer.parseInt(st2.nextToken());
		}

		for(int i = 0; i < n; i++) {
			if(a[i] == b[i]) {
				sb.append("D").append("\n");
			}
			else if(a[i] == SCISSORS) {
				if(b[i] == ROCK) {
					sb.append("B").append("\n");
				} else {
					sb.append("A").append("\n");
				}
			}
			else if(a[i] == ROCK) {
				if(b[i] == PAPER) {
					sb.append("B").append("\n");
				} else {
					sb.append("A").append("\n");
				}
			}
			else if(a[i] == PAPER) {
				if(b[i] == SCISSORS) {
					sb.append("B").append("\n");
				} else {
					sb.append("A").append("\n");
				}
			}
		}

		System.out.println(sb);
	}
}
