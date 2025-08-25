import java.io.*;
import java.util.*;

public class B2309 {
	static int[] a = new int[10];
	static List<Integer> li = new ArrayList<>();
	static boolean check = false;
	static final int n = 9;

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 9; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		go(0, 0);
	}

	static void go(int idx, int sum) {
		if(check) return;

		if(li.size() == 7 && sum == 100) {
			Collections.sort(li);

			for(int t : li) {
				System.out.println(t);
			}

			check = true;
			return;
		}

		if(idx == n) return;
		if(sum > 100) return;
		if(li.size() > 7) return;

		li.add(a[idx]);
		go(idx + 1, sum + a[idx]);
		li.remove(li.size() - 1);

		go(idx + 1, sum);
	}
}