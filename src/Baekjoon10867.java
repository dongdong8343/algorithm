import java.io.*;
import java.util.*;

public class Baekjoon10867 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hs = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] a = s.split(" ");

        for(String x : a) hs.add(Integer.parseInt(x));

        List<Integer> li = new ArrayList<>(hs);

        Collections.sort(li);

        li.forEach(x -> System.out.print(x + " "));

    }
}