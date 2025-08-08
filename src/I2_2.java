import java.io.*;
import java.util.*;

public class I2_2 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> li = new ArrayList<>();

		int be = -1, cnt = 0;

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}

		for(int x : li) {
			if(be < x) {
				cnt++;
				be = x;
			}
		}

		System.out.println(cnt);
	}
}
