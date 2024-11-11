import java.util.*;
import java.io.*;

public class Inflearn2_2 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 숫자들 입력
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int last = 0, cnt = 0;

        // 숫자들 순회하면서 last 숫자보다 크면 last 갱신하고 cnt++한다.
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(last < tmp) {
                last = tmp;
                cnt++;
            }
        }

        System.out.println(cnt);

        return;
    }
}
