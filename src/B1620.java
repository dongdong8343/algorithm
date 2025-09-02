import static java.lang.Character.*;

import java.io.*;
import java.util.*;

public class B1620 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Integer, String> num = new HashMap<>();
		Map<String, Integer> str = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for(int i = 1; i <= n; i++) {
			String s = br.readLine();
			num.put(i, s);
			str.put(s, i);
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			String question = br.readLine();

			if(Character.isDigit(question.charAt(0))) sb.append(num.get(Integer.parseInt(question))).append("\n");
			else sb.append(str.get(question)).append("\n");
		}

		System.out.println(sb);
	}
}