import java.util.*;
import java.io.*;
public class Baekjoon9996 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String st = br.readLine();
        int pos = st.indexOf('*');
        String pre = st.substring(0, pos);
        String sub = st.substring(pos+1);
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            if(str.length() < pre.length() + sub.length()) System.out.println("NE");
            else{
                String newPre = str.substring(0, pos);
                String newSub = str.substring(str.length() - sub.length());
                if(pre.equals(newPre) && sub.equals(newSub)) System.out.println("DA");
                else System.out.println("NE");
            }
        }
    }
}
