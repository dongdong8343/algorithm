import java.io.*;
import java.util.*;

public class B2828 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		int s = 1, e = m, ret = 0;

		for(int i = 0; i < k; i++) {
			int now = Integer.parseInt(br.readLine());
			int t = 0;
			if(s <= now && e >= now) continue;
			else if(e < now) {
				t = now - e;
				ret += t;
				e = now;
				s += t;
			} else {
				t = s - now;
				ret += t;
				s = now;
				e -= t;
			}
		}

		System.out.println(ret);
	}
}