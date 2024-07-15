import java.util.*;
import java.io.*;
public class Baekjoon2750 {
    static int n;
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            li.add(a);
        }
        Collections.sort(li);
        for(int i : li) System.out.println(i);
    }
}
