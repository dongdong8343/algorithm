import java.util.*;
import java.io.*;
public class Baekjoon2751 {
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            li.add(a);
        }
        Collections.sort(li);
        StringBuilder sb = new StringBuilder();
        for(int i : li) sb.append(i + "\n");
        System.out.println(sb);
    }
}