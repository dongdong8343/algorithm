import java.io.*;
import java.util.*;

public class I4_2 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean good = true;

		Map<Character, Integer> hs1 = new HashMap<>();
		Map<Character, Integer> hs2 = new HashMap<>();

		String s1 = br.readLine();
		String s2 = br.readLine();

		for(char c : s1.toCharArray()) {
			hs1.put(c, hs1.getOrDefault(c, 0) + 1);
		}
		for(char c : s2.toCharArray()) {
			hs2.put(c, hs2.getOrDefault(c, 0) + 1);
		}

		for(char c : hs1.keySet()) {
			if(!hs2.containsKey(c) || !hs1.get(c).equals(hs2.get(c))) {
				good = false;
				break;
			}
		}

		System.out.println(good ? "YES" : "NO");
	}
}