import java.io.*;
import java.util.*;
public class ReInflearn1_12 {
    static int n;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String temp = s.substring(7 * i, 7 * i + 7);
            temp = temp.replaceAll("#",  "1");
            temp = temp.replaceAll("\\*", "0");
            sb.append((char)Integer.parseInt(temp, 2));
        }
        System.out.println(sb.toString());
    }
}