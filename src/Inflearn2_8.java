import java.util.*;
import java.io.*;

public class Inflearn2_8 {
    static int n, num = 0, last = 0, cnt = 1;
    static List<Integer> li = new ArrayList<>();
    static int[][] a = new int[2][104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            a[0][i] = Integer.parseInt(st.nextToken());
            li.add(a[0][i]);
        }

        Collections.sort(li, Collections.reverseOrder());

        for(int x : li){
            if(last == x) {
                cnt++;
                continue;
            }
            num += cnt;
            cnt = 1;
            for(int i = 0; i < n; i++){
                if(a[0][i] == x) a[1][i] = num;
            }
            last = x;
        }


        for(int i = 0; i < n; i++){
            System.out.print(a[1][i] + " ");
        }

        return;
    }
}