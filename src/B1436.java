import java.io.*;

public class B1436 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int i = 666, cnt = 0;

		while(true) {
			if(String.valueOf(i).contains("666")) {
				cnt++;
			}

			if(cnt == n) {
				System.out.println(i);
				break;
			}

			i++;
		}
	}
}