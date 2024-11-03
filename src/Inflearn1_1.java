import java.util.*;
import java.io.*;

public class Inflearn1_1 {
    static int cnt = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char c = Character.toUpperCase(br.readLine().charAt(0));
        for(char t : s.toCharArray()){
            if(Character.toUpperCase(t) == c) cnt++;
        }
        System.out.println(cnt);
        return ;
    }
}
