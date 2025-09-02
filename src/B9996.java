/**
 * 한국이 그리울 땐 서버에 접속하지
 *
 * 문제를 잘 읽고 풀자...
 *
 * 아래는 실수한 부분이다.
 *
 * - '*' 앞 뒤로 문자 하나만 존재하는 것이 아니라 문자열이 존재한다..
 * - 입력받은 문자열이 패턴의 문자열의 합보다 작은 경우도 생각해야한다..
 *
 * 개선 사항
 *
 * - 스트림을 사용하면 불필요한 공간이 낭비됨 / 중간에 map, foreach를 거쳐야해서 시간도 단순 for문보다 오래 걸림
 */

import java.io.*;
import java.util.*;

public class B9996 {
	static int idx;
	static String pre, sub;

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<String> li = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());

		String p = br.readLine();

		idx = p.indexOf('*');
		pre = p.substring(0, idx);
		sub = p.substring(idx + 1);

		for(int i = 0; i < n; i++) {
			li.add(br.readLine());
		}

		li.stream()
			.map(s -> check(s) ? "DA" : "NE").forEach(System.out::println);
	}

	public static boolean check(String s) {
		if(s.length() < pre.length() + sub.length()) return false;

		String t1 = s.substring(0, pre.length());
		String t2 = s.substring(s.length() - sub.length());

		return pre.equals(t1) && sub.equals(t2);
	}
}