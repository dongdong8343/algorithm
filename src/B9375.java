/**
 * 경우의 수를 구하는 단순한 문제다.
 *
 * 옷을 아무것도 안입는 경우는 -1 해줘야한다는 사실을 잊지말자.
 */

import java.io.*;
import java.util.*;

public class B9375 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hs = new HashMap<>();

			for(int j = 0; j < m; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				st.nextToken();
				String name = st.nextToken();

				hs.put(name, hs.getOrDefault(name, 0) + 1);
			}

			int ret = 1;

			for(int v : hs.values()) {
				ret *= v + 1;
			}

			sb.append(--ret).append("\n");
		}

		System.out.println(sb);
	}
}