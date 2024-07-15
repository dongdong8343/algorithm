import java.util.*;
import java.io.*;
public class Baekjoon2587 {
    static int sum = 0;
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++){
            int a = Integer.parseInt(br.readLine());
            li.add(a);
            sum += a;
        }
        Collections.sort(li);
        System.out.println(sum / 5);
        System.out.println(li.get(2));
    }
}