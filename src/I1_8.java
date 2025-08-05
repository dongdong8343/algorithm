import java.io.*;
import java.util.*;

public class I1_8 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine().toLowerCase();
		String temp = "";

		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				temp += c;
			}
		}

		sb.append(temp).reverse();

		if (sb.toString().equals(temp)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}