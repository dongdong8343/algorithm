import java.util.*;
import java.io.*;

public class Inflearn5_6 {
    static int n, k, cnt = 0;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) q.add(i);

        while(q.size() > 1){
            int temp = q.poll();
            cnt++;
            if(cnt == k) {
                cnt = 0;
                continue;
            }
            q.add(temp);
        }

        System.out.println(q.poll());

        return ;
    }
}