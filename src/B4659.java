import java.io.*;
import java.util.*;

public class B4659 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] mo = {'a', 'i', 'e', 'o', 'u'};
		StringBuilder sb = new StringBuilder();

		while(true) {
			String s = br.readLine();

			if(s.equals("end")) break;

			boolean check = false;
			boolean error = false;
			char before = '0';
			int mcnt = 0, jcnt = 0;

			for(char c : s.toCharArray()) {
				boolean checkMo = false;
				if(c != 'e' && c != 'o') {
					if(before == c) {
						error = true;
						break;
					}
				}

				for(char t : mo) {
					if(c == t) {
						check = true;
						checkMo = true;
						break;
					}
				}

				if(checkMo) {
					mcnt++;
					jcnt = 0;
				} else {
					jcnt++;
					mcnt = 0;
				}

				if(jcnt >= 3 || mcnt >= 3) {
					error = true;
					break;
				}
				before = c;
			}

			sb.append("<").append(s);

			if(error || !check) {
				sb.append("> is not acceptable.");
			} else {
				sb.append("> is acceptable.");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}