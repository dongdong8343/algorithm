import java.io.*;
import java.util.*;

public class B4949 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			Deque<Character> st = new ArrayDeque<>();
			boolean error = false;

			String s = br.readLine();

			if(s.equals(".")) break;

			for(char c : s.toCharArray()) {
				if(c == '(' || c == '[') st.push(c);
				else if(c == ')' || c == ']') {
					if(check(c, st)) st.pop();
					else {
						error = true;
						break;
					}
				}
			}

			if(!st.isEmpty()) error = true;

			sb.append(error ? "no" : "yes").append("\n");
		}

		System.out.println(sb);
	}

	static boolean check(char c, Deque<Character> st) {
		char t = c == ')' ? '(' : '[';

		return !st.isEmpty() && st.peek() == t;
	}
}