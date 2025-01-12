import java.io.*;
import java.util.*;
public class CtBook3_3 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while(n != 1){
            if(n % m == 0) n /= m;
            else n--;
            cnt++;
        }

        System.out.println(cnt);
    }
}