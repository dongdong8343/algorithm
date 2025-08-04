import java.io.*;
import java.util.*;

public class I1_1 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		StringTokenizer st = new StringTokenizer(br.readLine());
		String c = st.nextToken();

		int ret = 0;

		for (char t : s.toCharArray()) {
			if(String.valueOf(t).equalsIgnoreCase(c)) {
				ret++;
			}
		}

		System.out.println(ret);
	}
}
