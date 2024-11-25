import java.util.*;
import java.io.*;

public class InflearnRe1_12 {
    static int n;
    static String s;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();

        s = s.replaceAll("#", "1");
        s = s.replaceAll("\\*", "0");

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(s.substring(7 * i, 7 * (i + 1)), 2);
            sb.append((char)temp);
        }

        System.out.println(sb.toString());

        return ;
    }
}