import java.io.*;

public class I1_9 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		StringBuilder sb = new StringBuilder();

		for(char c : s.toCharArray()) {
			if(Character.isDigit(c)) {
				sb.append(c);
			}
		}

		System.out.println(Integer.parseInt(sb.toString()));
	}
}