import java.util.*;
import java.io.*;
public class Baekjoon2941 {
    static int cnt;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while(!s.isEmpty()){
            String t1 = "";
            String t2 = "";
            if(s.length() >= 2){
                t1 = s.substring(0, 2);
            }
            if(s.length() >= 3){
                t2 = s.substring(0, 3);
            }
            if(t1.equals("c=") || t1.equals("c-") || t1.equals("d-") || t1.equals("lj") || t1.equals("nj") || t1.equals("s=") || t1.equals("z=")){
                cnt++;
                s = s.substring(2);
            }else if(t2.equals("dz=")){
                cnt++;
                s = s.substring(3);
            }else{
                cnt++;
                s = s.substring(1);
            }
        }
        System.out.println(cnt);
    }
}