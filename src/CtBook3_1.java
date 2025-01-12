import java.io.*;
import java.util.*;
public class CtBook3_1 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ret = 0, cnt = 0;
        ArrayList<Integer> li = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) li.add(Integer.parseInt(st.nextToken()));

        Collections.sort(li, Collections.reverseOrder());

        while(m > 0){
            cnt++;
            m--;
            if(cnt > k){
                cnt = 0;
                ret += li.get(1);
            }else{
                ret += li.get(0);
            }
        }

        System.out.println(ret);
    }
}