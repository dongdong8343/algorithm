import java.io.*;
import java.util.*;
public class BaekjoonReRe9996 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String pat = br.readLine();
        int idx = pat.indexOf('*');
        String pre = pat.substring(0, idx);
        String sub = pat.substring(idx + 1, pat.length());
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            if(word.length() < pre.length() + sub.length()){
                System.out.println("NE");
                continue;
            }
            String newPre = word.substring(0, pre.length());
            String newSub = word.substring(word.length() - sub.length());
            if(newPre.equals(pre) && newSub.equals(sub))
                System.out.println("DA");
            else
                System.out.println("NE");
        }
    }
}
