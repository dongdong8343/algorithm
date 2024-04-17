import java.util.*;
import java.io.*;
public class Baekjoon2908 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        a.append(st.nextToken());
        b.append(st.nextToken());
        a.reverse();
        b.reverse();
        if(Integer.parseInt(a.toString()) > Integer.parseInt(b.toString()))
            System.out.println(a.toString());
        else
            System.out.println(b.toString());
    }
}
