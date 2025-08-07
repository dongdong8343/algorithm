import java.io.*;
import java.util.*;

public class I1_10 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> li = new ArrayList<>();
		int[] a = new int[104];
		Arrays.fill(a, 999);

		String s = st.nextToken();
		char c = st.nextToken().charAt(0);

		// t의 위치 구하기
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == c) {
				li.add(i);
			}
		}

		// 문자열 돌면서 t의 위치의 차를 절댓값으로 구한 후 최솟값을 배열에 순서대로 저장
		for(int i = 0; i < s.length(); i++) {
			for(int j : li) {
				int t = Math.abs(i - j);
				if(a[i] > t) {
					a[i] = t;
				}
			}
		}

		// 출력
		for(int i = 0; i < s.length(); i++) {
			System.out.print(a[i] + " ");
		}
	}
}
