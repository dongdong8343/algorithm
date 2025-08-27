import java.io.*;
import java.util.*;

public class B10808 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] a = new int[26];

		String s = br.readLine();

		for(char c : s.toCharArray()) {
			a[c - 'a']++;
		}

		for(int i = 0; i < 26; i++) {
			sb.append(a[i]).append(' ');
		}

		System.out.println(sb);
	}
}