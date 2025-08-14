import java.io.*;
import java.util.*;

public class I3_6 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] a = new int[n + 4];
		int l = 0, r = 0, cnt = 0, ret = 0;

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		while(r < n) {
			r++;
			if(a[r] == 0){
				cnt++;
				if(cnt > m) {
					while(a[l] != 0) { l++; }
					l++;
					cnt--;
				}
			}
			ret = Math.max(ret, r - l + 1);
		}

		System.out.println(ret);
	}
}
