import java.io.*;

public class I1_11 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		int cnt = 0;
		char t = s.charAt(0);

		// 문자열 순회하면서 다른 문자가 나오면 cnt 1로 초기화, 앞에 문자와 숫자 출력(1인 경우 출력 x)
		// 문자 바꾼다.
		for(char c : s.toCharArray()) {
			if(t != c) {
				sb.append(t);
				if(cnt != 1){
					sb.append(cnt);
				}
				cnt = 1;
				t = c;
			} else {
				cnt++;
			}
		}

		sb.append(t);
		if(cnt != 1){
			sb.append(cnt);
		}

		// 마지막에 문자, 숫자 출력
		System.out.println(sb);
	}
}
