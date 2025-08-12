import java.io.*;
import java.util.*;

public class I3_1 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> li = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}

		li.sort(Comparator.comparingInt(o -> o));

		for(int t : li) {
			System.out.print(t + " ");
		}
	}
}
