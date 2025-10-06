import java.io.*;
import java.util.*;

public class B9012 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			Stack<Character> st = new Stack<>();
			boolean error = false;

			for(char c : s.toCharArray()) {
				if(c == '(') st.push(c);
				else {
					if(!st.isEmpty()) {
						st.pop();
					} else {
						error = true;
						break;
					}
				}
			}

			sb.append((error || !st.isEmpty()) ? "NO" : "YES").append("\n");
		}

		System.out.println(sb);
	}
}