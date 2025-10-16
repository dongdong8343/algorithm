import java.io.*;
import java.util.*;
import java.awt.Point;

public class B15686 {
	static List<Point> house = new ArrayList<>();
	static List<Point> chi = new ArrayList<>();
	static List<Point> temp = new ArrayList<>();
	static int ret = Integer.MAX_VALUE, m;

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int now = Integer.parseInt(st.nextToken());

				if(now == 1) house.add(new Point(j, i));
				else if(now == 2) chi.add(new Point(j, i));
			}
		}

		go(0, 0);

		System.out.println(ret);
	}

	static void go(int cnt, int now) {
		if(cnt == m) {
			cal();
			return;
		}

		if(now >= chi.size()) return;

		Point p = chi.get(now);
		temp.add(p);
		go(cnt + 1, now + 1);
		temp.remove(p);

		go(cnt, now + 1);
	}

	static void cal() {
		int sum = 0;

		for(Point p1 : house) {
			int min = Integer.MAX_VALUE;
			for(Point p2 : temp) {
				min = Math.min(min, Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y));
			}
			sum += min;
			if(sum >= ret) return;
		}

		ret = sum;
	}
}