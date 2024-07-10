import java.util.*;
import java.io.*;
public class Baekjoon2525 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int take = Integer.parseInt(br.readLine());
        m += take;
        if(m >= 60){
            h += m / 60;
            if(h >= 24) h -= 24;
            m %= 60;
        }
        System.out.println(h + " " + m);
    }
}