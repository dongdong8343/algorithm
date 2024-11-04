import java.util.*;
import java.io.*;

public class Inflearn1_3{
    static String ret = "";
    static int max = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = s.split(" ");
        for(String t : arr){
            if(t.length() > max){
                max = t.length();
                ret = t;
            }
        }
        System.out.println(ret);
        return;
    }
}
