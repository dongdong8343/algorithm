import java.io.*;
import java.util.*;

public class B2870 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> li = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());

		for(int t = 0; t < n; t++) {
			String s = br.readLine();
			StringBuilder sb = new StringBuilder();

			for(char c : s.toCharArray()) {
				if(Character.isDigit(c)) sb.append(c);
				else {
					if(sb.length() != 0) {
						li.add(go(sb));
						sb.setLength(0);
					}
				}
			}
			if(sb.length() != 0) li.add(go(sb));
		}

		li.sort((o1, o2) -> {
			if(o1.length() != o2.length()) return o1.length() - o2.length();

			for(int i = 0; i < o1.length(); i++) {
				if(o1.charAt(i) == o2.charAt(i)) continue;
				return o1.charAt(i) - o2.charAt(i);
			}

			return 0;
		});

		li.forEach(System.out::println);
	}

	static String go(StringBuilder sb) {
		if(sb.length() == 1) return sb.toString();

		while(true) {
			if(sb.charAt(0) == '0' && sb.length() == 1) break;
			if(sb.charAt(0) == '0') sb.deleteCharAt(0);
			else break;
		}

		return sb.toString();
	}
}