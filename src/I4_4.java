import java.io.*;
import java.util.*;

public class I4_4 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Character, Integer> hs = new HashMap<>();
		Map<Character, Integer> ori = new HashMap<>();

		int ret = 0, l = 0;

		String s = br.readLine();
		String t = br.readLine();

		for(char temp : t.toCharArray()) {
			ori.put(temp, ori.getOrDefault(temp, 0) + 1);
		}

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			boolean check = true;

			hs.put(c, hs.getOrDefault(c, 0) + 1);

			if(i >= t.length()) {
				char temp = s.charAt(l++);
				hs.put(temp, hs.get(temp) - 1);
				if(hs.get(temp) == 0) {
					hs.remove(temp);
				}
			}

			for(char key : t.toCharArray()) {
				if(!hs.containsKey(key)) {
					check = false;
					break;
				}
				if(!Objects.equals(hs.get(key), ori.get(key))) {
					check = false;
					break;
				}
			}

			if(check) ret++;
		}

		System.out.println(ret);
	}
}