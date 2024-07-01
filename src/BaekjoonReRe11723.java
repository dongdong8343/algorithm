import java.util.*;
import java.io.*;
public class BaekjoonReRe11723 {
    static int m;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m = Integer.parseInt(br.readLine());
        int mask = 0;
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("all")) mask = (1 << 21) - 1;
            else if(command.equals("empty")) mask = 0;
            else{
                int n = Integer.parseInt(st.nextToken());
                if(command.equals("add")) mask |= (1 << n);
                else if(command.equals("remove")) mask &= ~(1 << n);
                else if(command.equals("check")){
                    if((mask & (1 << n)) != 0) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                }
                else if(command.equals("toggle")) mask ^= (1 << n);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}