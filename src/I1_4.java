import java.io.*;
import java.util.*;

public class I1_4 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			String s = br.readLine();

			for(int j = s.length() - 1; j >= 0; j--) {
				sb.append(s.charAt(j));
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}
}