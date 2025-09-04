/**
 * 테스트 케이스를 작게 작게 만들어서 규칙을 찾자.
 *
 * 그래서 규칙을 찾아보면 알파벳의 개수를 파악하고 개수가 홀수인 알파벳이 2개 이상 존재하면 팰린드롬이 될 수 없다.
 */

import java.io.*;

public class B1213 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder ret = new StringBuilder();
		char mid = ' ';
		int flag = 0;
		int[] a = new int[200];
		String s = br.readLine();

		for(int i = 0; i < s.length(); i++) {
			a[s.charAt(i)]++;
		}

		for(char i = 'Z'; i >= 'A'; i--) {
			if(a[i] % 2 == 1) {
				flag++;
				mid = i;
				a[i]--;
			}

			if(flag == 2) break;

			for(int j = 0; j < a[i]; j += 2) {
				ret.insert(0, i).append(i);
			}
		}

		if(flag == 2) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			if(mid != ' ') {
				ret.insert(ret.length() / 2, mid);
			}

			System.out.println(ret);
		}
	}
}