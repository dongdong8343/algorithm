import java.io.*;
import java.util.*;

public class B2309_3 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] a = new int[9];
		int sum = 0, first = 0, second = 0;
		boolean check = false;
		List<Integer> li = new ArrayList<>();

		for(int i = 0; i < 9; i++) {
			a[i] = Integer.parseInt(br.readLine());
			sum += a[i];
		}

		for(int i = 0; i < 9; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(sum - a[i] - a[j] == 100) {
					first = i;
					second = j;
					check = true;
					break;
				}
			}
			if(check) break;
		}

		for(int i = 0; i < 9; i++) {
			if(first == i || second == i) continue;
			li.add(a[i]);
		}

		Collections.sort(li);

		li.forEach(System.out::println);
	}
}