import java.io.*;
import java.util.*;
public class Baekjoon1138 {
    static int n;
    static int[] a = new int[14];
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n - 1; i >= 0; i--){
            li.add(a[i], i + 1);
        }

        for(int x : li) System.out.print(x + " ");
    }
}