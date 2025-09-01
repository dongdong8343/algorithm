import java.io.*;
import java.util.*;

public class B11655 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		String s = br.readLine();

		for(char c : s.toCharArray()) {
			char next = c;

			if(Character.isAlphabetic(c)) {
				next = (char)(c + 13);
				if(Character.isUpperCase(c)) {
					if(next > 'Z') {
						next = (char)('A' + c + 13 - 'Z' - 1);
					}
				} else {
					if(next > 'z') {
						next = (char)('a' + c + 13 - 'z' - 1);
					}
				}
			}

			sb.append(next);
		}

		System.out.println(sb);
	}
}