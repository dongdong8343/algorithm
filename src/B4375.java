import java.util.*;

public class B4375 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			int ret = 0, a = 0;

			do {
				a = a * 10 + 1;
				ret++;
				a %= n;
			} while (a != 0);

			System.out.println(ret);
		}
	}
}