import java.io.*;

public class I2_5 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] a = new boolean[200004];

		int n  = Integer.parseInt(br.readLine());
		int cnt = 0;

		for(int i = 2; i <= n; i++) {
			if(a[i]) {
				continue;
			}
			for(int j = 2 * i; j <= n; j += i) {
				a[j] = true;
			}
		}

		for(int i = 2; i <= n; i++) {
			if(!a[i]) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
