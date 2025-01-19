import java.io.*;
import java.util.*;
public class BaekjoonRe10815 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hs = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            hs.put(temp, 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(hs.containsKey(temp)) System.out.print(1 + " ");
            else System.out.print(0 + " ");
        }
    }
}