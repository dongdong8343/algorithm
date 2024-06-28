import java.util.*;
import java.io.*;
public class BaekjoonRe11723 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int s = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if(com.equals("all")) s = (1 << 21) - 1;
            else if(com.equals("empty")) s = 0;
            else{
                int num = Integer.parseInt(st.nextToken());
                if(com.equals("add")) s |= (1 << num);
                else if(com.equals("remove")) s &= ~(1 << num);
                else if(com.equals("check")){
                    if((s & (1 << num)) != 0) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                }
                else if(com.equals("toggle")) s ^= (1 << num);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}