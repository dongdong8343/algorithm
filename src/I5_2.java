import java.io.*;
import java.util.*;

public class I5_2 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();

		for(char c : s.toCharArray()) {
			if(c == '(') {
				st.push(c);
			} else if(c == ')'){
				st.pop();
			} else {
				if(st.isEmpty()) {
					sb.append(c);
				}
			}
		}

		System.out.println(sb);
	}
}