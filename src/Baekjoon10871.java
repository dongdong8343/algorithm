import java.util.*;
import java.io.*;
public class Baekjoon10871 {
    static int n, x;
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            li.add(Integer.parseInt(st.nextToken()));
        }
        for(int i : li){
            if(i < x) System.out.print(i + " ");
        }
    }
}