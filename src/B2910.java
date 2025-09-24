import java.io.*;
import java.util.*;

public class B2910 {
	static class Box {
		int idx;
		int cnt;

		public Box(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		Map<Integer, Box> map = new HashMap<>();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
			int num = Integer.parseInt(st.nextToken());

			if(map.containsKey(num)) {
				Box box = map.get(num);
				box.cnt++;
			} else {
				Box box = new Box(i, 1);
				map.put(num, box);
			}
		}

		List<Map.Entry<Integer, Box>> li = new ArrayList<>(map.entrySet());

		li.sort((o1, o2) -> {
			Box a = o1.getValue();
			Box b = o2.getValue();

			if(a.cnt == b.cnt) return a.idx - b.idx;

			return b.cnt - a.cnt;
		});

		li.forEach(t -> {
			int key = t.getKey();
			Box box = t.getValue();

			for(int i = 0; i < box.cnt; i++) {
				sb.append(key).append(" ");
			}
		});

		System.out.println(sb);
	}
}