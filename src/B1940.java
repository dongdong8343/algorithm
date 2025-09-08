import java.io.*;
import java.util.*;

public class B1940 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Integer, Integer> map = new HashMap<>();

		int ret = 0;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			map.put(i, Integer.parseInt(st.nextToken()));
		}

		for(int i = 0; i < n; i++) {
			int idx = m - map.get(i);
			if(map.containsValue(idx)) ret++;
		}

		System.out.println(ret / 2);
	}
}