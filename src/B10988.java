import java.io.*;

public class B10988 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		String t = new StringBuilder(s).reverse().toString();

		System.out.println(s.equals(t) ? 1 : 0);
	}
}