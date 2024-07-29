import java.util.*;
import java.io.*;
public class BaekjoonRe11723_4 {
    static int n, s = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("all")) s = (1 << 21) - 1;
            else if(str.equals("empty")) s = 0;
            else{
                int x = Integer.parseInt(st.nextToken());
                if(str.equals("add")) s |= (1 << x);
                else if(str.equals("remove")) s &= ~(1 << x);
                else if(str.equals("check")){
                    if((s & (1 << x)) != 0) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                }
                else if(str.equals("toggle")) s ^= (1 << x);
            }
        }
        System.out.println(sb);
    }
}