import java.io.*;
import java.util.*;

public class I5_4 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		Stack<Integer> st = new Stack<>();

		for(char c : s.toCharArray()) {
			if(Character.isDigit(c)) {
				int t = Integer.parseInt(String.valueOf(c));
				st.push(t);
			} else {
				int b = st.pop();
				int a = st.pop();

				if(c == '+') {
					st.push(a + b);
				} else if(c == '-') {
					st.push(a - b);
				} else if (c == '*') {
					st.push(a * b);
				} else {
					st.push(a / b);
				}
			}
		}

		System.out.println(st.pop());
	}
}