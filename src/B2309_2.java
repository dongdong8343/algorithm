import java.io.*;
import java.util.*;

public class B2309_2 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 9, sum = 0, num1 = 0, num2 = 0;
		boolean check = false;
		int[] a = new int[9];
		List<Integer> li = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			sum += a[i];
		}

		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(sum - a[i] - a[j] == 100) {
					num1 = i;
					num2 = j;
					check = true;
					break;
				}
			}
			if(check) break;
		}

		for(int i = 0; i < n; i++) {
			if(i == num1 || i == num2) {
				continue;
			}
			li.add(a[i]);
		}

		Collections.sort(li);

		for(int t : li) {
			System.out.println(t);
		}
	}
}