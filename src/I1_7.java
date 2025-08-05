import java.io.*;
import java.util.*;

public class I1_7 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		boolean flag = true;

		for(int i = 0; i < s.length() / 2; i++) {
			char a = Character.toLowerCase(s.charAt(i));
			char b = Character.toLowerCase(s.charAt(s.length() - (i + 1)));

			if(a != b) {
				flag = false;
				break;
			}
		}

		System.out.println(flag ? "YES" : "NO");
	}
}