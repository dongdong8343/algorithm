import java.util.*;
import java.io.*;

public class Inflearn_1_11 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        char last = ' ';
        int num = 1;

        for(char c : s.toCharArray()){
            if(c != last){
                if(num != 1) sb.append(num);
                sb.append(c);
                num = 1;
                last = c;
            }
            else num++;
        }
        if(num != 1) sb.append(num);
        System.out.println(sb.toString());
        return ;
    }
}