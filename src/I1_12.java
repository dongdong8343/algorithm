import java.io.*;

public class I1_12 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();

		for(int i = 0; i < n; i++) {
			String tmp = s.substring(i * 7, i * 7 + 7);
			String bi = tmp.replace('#', '1').replace('*', '0');

			int num = Integer.parseInt(bi, 2);
			System.out.printf("%c", num);
		}
	}
}
