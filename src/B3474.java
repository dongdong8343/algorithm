import java.io.*;

public class B3474 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			int t = Integer.parseInt(br.readLine());
			int ret = 0;

			for(int j = 5; j <= t; j *= 5) {
				ret += t / j;
			}

			sb.append(ret).append("\n");
		}

		System.out.println(sb);
	}
}