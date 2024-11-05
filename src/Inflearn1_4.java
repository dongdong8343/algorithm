import java.util.*;
import java.io.*;

public class Inflearn1_4 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            StringBuffer sb = new StringBuffer();
            sb.append(br.readLine());
            System.out.println(sb.reverse());
        }

        return ;
    }
}