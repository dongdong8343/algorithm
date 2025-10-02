import java.io.*;
import java.util.*;

public class B2852 {
	static class Time {
		int min;
		int sec;

		Time() {
			this.min = 0;
			this.sec = 0;
		}

		Time(String time) {
			String[] temp = time.split(":");

			this.min = Integer.parseInt(temp[0]);
			this.sec = Integer.parseInt(temp[1]);
		}

		void cal(Time before, Time now) {
			int min = now.min - before.min, sec;

			if(now.sec < before.sec) {
				sec = 60 - before.sec + now.sec;
				min--;
			} else {
				sec = now.sec - before.sec;
			}

			this.min += min;
			this.sec += sec;

			if(this.sec >= 60) {
				this.sec -= 60;
				this.min++;
			}
		}

		@Override
		public String toString() {
			String min = this.min < 10 ? "0" + this.min : String.valueOf(this.min);
			String sec = this.sec < 10 ? "0" + this.sec : String.valueOf(this.sec);

			return min + ":" + sec;
		}
	}

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] a = new int[3];
		Time before = new Time(), ret1 = new Time(), ret2 = new Time();

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int team = Integer.parseInt(st.nextToken());
			Time now = new Time(st.nextToken());

			if(a[1] > a[2]) {
				ret1.cal(before, now);
			} else if(a[2] > a[1]) {
				ret2.cal(before, now);
			}
			a[team]++;
			before = now;
		}

		Time now = new Time("48:00");

		if (a[1] > a[2]) {
			ret1.cal(before, now);
		} else if(a[2] > a[1]) {
			ret2.cal(before, now);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(ret1).append("\n");
		sb.append(ret2).append("\n");

		System.out.println(sb);
	}
}