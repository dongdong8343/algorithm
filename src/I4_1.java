import java.io.*;
import java.util.*;

public class I4_1 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Integer> map = new HashMap<>();

		int n = Integer.parseInt(br.readLine());

		String s = br.readLine();

		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int max = map.values().stream().max(Integer::compareTo).get();

		for(char c : map.keySet()) {
			if(map.get(c) == max) {
				System.out.println(c);
				return;
			}
		}
	}
}