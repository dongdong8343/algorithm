import java.io.*;
import java.util.*;

public class I5_1 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> st = new Stack<>();

		String s = br.readLine();
		boolean check = true;

		for(char c : s.toCharArray()) {
			if(c == '(') {
				st.push(c);
			} else {
				if(st.isEmpty()) {
					check = false;
					break;
				} else {
					st.pop();
				}
			}
		}

		if(!st.isEmpty()) {
			check = false;
		}

		System.out.println(check ? "YES" : "NO");
	}
}