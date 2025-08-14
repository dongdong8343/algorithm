import java.io.*;
import java.util.*;

public class I3_5 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int sum = 0, l = 1, r = 1, ret = 0;

		while(true) {
			if(sum < n) {
				sum += r++;
			}
			if (sum > n) {
				sum -= l++;
				if(r > n) break;
			}
			if (sum == n) {
				sum -= l++;
				ret++;
			}
		}

		System.out.println(ret);
	}
}