import java.util.*;
import java.io.*;
public class Baekjoon3052 {
    static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 10; i++){
            int n = Integer.parseInt(br.readLine());
            hs.add(n % 42);
        }
        System.out.println(hs.size());
    }
}