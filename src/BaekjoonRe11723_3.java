import java.util.*;
import java.io.*;
public class BaekjoonRe11723_3 {
    static int n;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int mask = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("all")) mask = (1 << 21) - 1;
            else if(s.equals("empty")) mask = 0;
            else{
                int a = Integer.parseInt(st.nextToken());
                if(s.equals("add")) mask |= (1 << a);
                else if(s.equals("remove")) mask &= ~(1 << a);
                else if(s.equals("check")){
                    if((mask & (1 << a)) != 0) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                }
                else if(s.equals("toggle")) mask ^= (1 << a);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}