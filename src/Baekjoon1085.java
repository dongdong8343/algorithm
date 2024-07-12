import java.util.*;
import java.io.*;
public class Baekjoon1085 {
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        li.add(Math.abs(x - 0));
        li.add(Math.abs(y - 0));
        li.add(Math.abs(x - w));
        li.add(Math.abs(y - h));
        Collections.sort(li);
        System.out.println(li.get(0));
    }
}