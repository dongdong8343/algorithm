import java.io.*;
import java.util.*;

public class I3_2 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> hs = new HashMap<>();
		List<Integer> li = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++){
			int t = Integer.parseInt(st.nextToken());
			hs.put(t, hs.getOrDefault(t, 0) + 1);
		}

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++){
			int t = Integer.parseInt(st.nextToken());
			hs.put(t, hs.getOrDefault(t, 0) + 1);
		}

		for(int t : hs.keySet()) {
			if(hs.get(t) == 2) {
				li.add(t);
			}
		}

		Collections.sort(li);

		for(int x : li) {
			System.out.print(x + " ");
		}
	}
}