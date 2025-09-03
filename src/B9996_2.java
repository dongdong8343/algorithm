import java.io.*;
import java.util.*;

public class B9996_2 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String pattern = br.readLine();
		int idx = pattern.indexOf('*');
		String pre = pattern.substring(0, idx);
		String sub = pattern.substring(idx + 1);

		for(int i = 0; i < n; i++) {
			String s = br.readLine();

			if(check(pre, sub, s)) {
				sb.append("DA").append("\n");
			} else {
				sb.append("NE").append("\n");
			}
		}

		System.out.println(sb);
	}

	static boolean check(String pre, String sub, String s) {
		// ab*b => ab 통과 안되게 막아야함... 즉 길이 체크 필수
		if(s.length() < pre.length() + sub.length()) return false;

		return s.startsWith(pre) && s.endsWith(sub);
	}
}