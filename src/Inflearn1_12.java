import java.util.*;
import java.io.*;

public class Inflearn1_12 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String ret = "";

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 7; j++){
                if(s.charAt(j + 7 * i) == '#') sb.append(1);
                else sb.append(0);
            }
            int num = Integer.parseInt(sb.toString(), 2);
            ret += (char)num;
        }

        System.out.println(ret);

        return;
    }
}
