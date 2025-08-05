import java.io.*;

public class I1_5 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int idx = 0;

		// sb에 순수 문자만 담는다.
		StringBuilder sb = new StringBuilder();
		StringBuilder ret = new StringBuilder();

		for(char c : s.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				sb.append(c);
			}
		}

		// sb를 뒤집는다.
		sb.reverse();

		// 기존 문자를 순회하면서 특수 문자가 아닌 자리면 뒤집은 문자 출력
		for(char c : s.toCharArray()) {
			if(Character.isAlphabetic(c)) {
				ret.append(sb.charAt(idx++));
			}else {
				ret.append(c);
			}
		}

		System.out.println(ret);
	}
}
