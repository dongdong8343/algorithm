import java.io.*;
import java.util.*;

public class I2_7 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int sum = 0, cnt = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(st.nextToken());

			if (t == 1) {
				cnt++;
				sum += cnt;
			} else {
				cnt = 0;
			}
		}

		System.out.println(sum);
	}
}