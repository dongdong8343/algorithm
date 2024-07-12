import java.util.*;
import java.io.*;
public class Baekjoon24313 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());
        if(x * z + y <= c * z && c >= x) System.out.println(1);
        else System.out.println(0);
    }
}