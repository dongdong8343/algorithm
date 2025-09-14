import java.io.*;
import java.util.*;

public class B9996_3 {
	static int idx;
	static String pre, sub;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		String pattern = br.readLine();
		idx = pattern.indexOf('*');
		pre = pattern.substring(0, idx);
		sub = pattern.substring(idx + 1);

		for(int i = 0; i < n; i++) {
			String t = br.readLine();
			if(check(t)) {
				sb.append("DA").append("\n");
			} else {
				sb.append("NE").append("\n");
			}
		}

		System.out.println(sb);
	}

	static boolean check(String t) {
		if(t.length() < pre.length() + sub.length()) {
			return false;
		}

		String s = t.substring(0, pre.length());
		String e = t.substring(t.length() - sub.length());

		return Objects.equals(s, pre) && Objects.equals(e, sub);
	}

}