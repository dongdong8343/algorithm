/**
 * 경우의 수를 구하는 문제
 *
 * 의상의 종류 별로 가지고 있는 템 수 파악
 *
 * 종류 별로 하나씩 만 입는 경우는 아이템 수와 동일하다.
 * 추가로 종류 별로 있는 아이템을 모두 안입는 경우도 존재한다. 이 경우도 추가한다.
 *
 * 위와 같이 구한 후 종류 별로 입을 수 있는 경우의 수를 곱하면 모든 경우의 수가 나온다.
 * 마지막으로 모든 의상을 압입는 경우 -1을 해주면 해답이 나온다.
 */

import java.io.*;
import java.util.*;

public class B9375_2 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			Map<String, Integer> hs = new HashMap<>();
			int m = Integer.parseInt(br.readLine());
			int ret = 1;

			for(int j = 0; j < m; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				st.nextToken();
				String type = st.nextToken();

				hs.put(type, hs.getOrDefault(type, 0) + 1);
			}

			for(int v : hs.values()) {
				int t = v + 1;
				ret *= t;
			}

			sb.append(--ret).append("\n");
		}

		System.out.println(sb);
	}
}