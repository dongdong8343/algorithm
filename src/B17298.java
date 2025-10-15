import java.io.*;
import java.util.*;
import java.awt.Point;

public class B17298 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Point> stack = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			int m = Integer.parseInt(st.nextToken());

			while(!stack.isEmpty() && stack.peek().y < m) {
				a[stack.pop().x] = m;
			}

			stack.push(new Point(i, m));
		}

		while(!stack.isEmpty()) {
			a[stack.pop().x] = -1;
 		}

		StringBuilder sb = new StringBuilder();
		Arrays.stream(a).forEach(o -> sb.append(o).append(" "));
		System.out.println(sb);
	}
}