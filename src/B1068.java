import java.io.*;
import java.util.*;

public class B1068 {
	static List<Integer>[] a;
	static int ret = 0;
	static int del, root;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		del = Integer.parseInt(br.readLine());

		a = new List[n];

		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == -1) {
				root = i;
				continue;
			}
			a[num].add(i);
		}

		System.out.println(del == root ? 0 : go(root));
	}

	static int go(int num) {
		int cnt = 0;

		if(a[num].isEmpty()) {
			return 1;
		}

		for(int t : a[num]) {
			if(t == del) {
				if(a[num].size() == 1) return 1;
				else continue;
			}
			cnt += go(t);
		}

		return cnt;
	}

}