import java.util.*;
import java.io.*;
public class Baekjoon14215 {
    static int sum = 0;
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            int a = Integer.parseInt(st.nextToken());
            li.add(a);
            sum += a;
        }
        Collections.sort(li);
        if(li.get(2) < li.get(0) + li.get(1)) System.out.println(sum);
        else{
            int t = li.get(0) + li.get(1) + (li.get(0) + li.get(1) - 1);
            System.out.println(t);
        }
    }
}