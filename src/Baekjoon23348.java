import java.util.*;
import java.io.*;
public class Baekjoon23348 {
    static int n, na, nb, nc;
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        na = Integer.parseInt(st.nextToken());
        nb = Integer.parseInt(st.nextToken());
        nc = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int ts = 0;
            for(int j = 0; j < 3; j++){
                st = new StringTokenizer(br.readLine());
                int ta = Integer.parseInt(st.nextToken());
                int tb = Integer.parseInt(st.nextToken());
                int tc = Integer.parseInt(st.nextToken());
                ts += ta * na + tb * nb + tc * nc;
            }
            li.add(ts);
        }

        Collections.sort(li);
        System.out.println(li.get(n - 1));
    }
}