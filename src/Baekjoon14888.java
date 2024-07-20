import java.util.*;
import java.io.*;
public class Baekjoon14888 {
    static int n, max = -1987654321, min = 1987654321;
    static int[] a = new int[20];
    static List<Character> ch = new ArrayList<>();
    static void go(int now, int idx, int[] v){
        if(idx == n) {
            max = Math.max(max, now);
            min = Math.min(min, now);
        }
        for(int i = 0; i < ch.size(); i++){
            if(v[i] == 1) continue;
            v[i] = 1;
            if(ch.get(i) == '+') go(now + a[idx], idx + 1, v);
            if(ch.get(i) == '-') go(now - a[idx], idx + 1, v);
            if(ch.get(i) == '*') go(now * a[idx], idx + 1, v);
            if(ch.get(i) == '/') go(now / a[idx], idx + 1, v);
            v[i] = 0;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            a[i] = num;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++){
                if(i == 0) ch.add('+');
                if(i == 1) ch.add('-');
                if(i == 2) ch.add('*');
                if(i == 3) ch.add('/');
            }
        }
        int[] v = new int[15];
        go(a[0], 1, v);
        System.out.println(max);
        System.out.println(min);
    }
}