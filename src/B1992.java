import java.io.*;

public class B1992 {
	static int[][] a = new int[70][70];

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}

		System.out.println(go(0, n, 0, n));
	}

	static String go(int sy, int ey, int sx, int ex) {
		if(ey - sy == 1) {
			return String.valueOf(a[sy][sx]);
		}

		StringBuilder sb = new StringBuilder("(");

		int y = (sy + ey) / 2, x = (sx + ex) / 2;

		StringBuilder temp = new StringBuilder(go(sy, y, sx, x));
		temp.append(go(sy, y, x, ex));
		temp.append(go(y, ey, sx, x));
		temp.append(go(y, ey, x, ex));

		if(temp.toString().equals("0000")) return "0";
		else if(temp.toString().equals("1111")) return "1";

		return sb.append(temp).append(")").toString();
	}
}