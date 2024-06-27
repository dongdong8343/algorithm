import java.util.*;
import java.io.*;
public class Baekjoon11723 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int mask = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("all")) {
                mask = (1 << 21) - 1;
                continue;
            }
            if(command.equals("empty")) {
                mask = 0;
                continue;
            }
            int num = Integer.parseInt(st.nextToken());
            if(command.equals("add")) mask |= (1 << num);
            else if(command.equals("remove")) mask &= ~(1 << num);
            else if(command.equals("check")){
                if((mask & (1 << num)) != 0) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            }
            else if(command.equals("toggle")) mask ^= (1 << num);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}