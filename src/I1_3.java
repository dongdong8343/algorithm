import java.io.*;

public class I1_3 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		String ret = "";

		for(String t : s) {
			if(ret.length() < t.length()) {
				ret = t;
			}
		}

		System.out.println(ret);
	}
}