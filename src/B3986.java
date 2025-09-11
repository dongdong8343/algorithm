import java.io.*;
import java.util.*;

public class B3986 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ret = 0;
		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			if(check(s)) {
				ret++;
			}
		}

		System.out.println(ret);
	}

	public static boolean check(String s) {
		if(s.length() % 2 == 1) {
			return false;
		}

		Stack<Character> st = new Stack<>();

		for(char c : s.toCharArray()) {
			if(!st.isEmpty() && c == st.peek()) {
				st.pop();
				continue;
			}
			st.push(c);
		}

		return st.isEmpty();
	}
}