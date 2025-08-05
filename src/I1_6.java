import java.io.*;
import java.util.*;

public class I1_6 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new LinkedHashSet<>();

		String s = br.readLine();

		for(char c : s.toCharArray()) {
			set.add(c);
		}

		set.forEach(sb::append);

		System.out.println(sb);
	}
}
