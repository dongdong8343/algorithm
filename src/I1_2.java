import java.io.*;

public class I1_2 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();

		for(char c : s.toCharArray()) {
			if(Character.isLowerCase(c)) {
				sb.append(Character.toUpperCase(c));
			}
			else {
				sb.append(Character.toLowerCase(c));
			}
		}

		System.out.println(sb);
	}
}