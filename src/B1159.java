import java.io.*;
import java.util.*;

public class B1159 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Character, Integer> map = new HashMap<>();
		List<Character> li = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			char c = s.charAt(0);

			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		map.entrySet().stream()
			.filter(e -> e.getValue() >= 5)
			.map(Map.Entry::getKey)
			.sorted()
			.forEach(System.out::print);

		if(map.values().stream().allMatch(v -> v < 5)) {
			System.out.print("PREDAJA");
		}
	}
}