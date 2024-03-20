import java.util.*;
import java.io.*;
public class BaekjoonRe9996 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        int index = pattern.indexOf('*');
        String pre = pattern.substring(0, index);
        String sub = pattern.substring(index + 1);
        for(int i = 0; i < n; i++){
            String file = br.readLine();
            if(file.length() >= pre.length() + sub.length()){
                String fp = file.substring(0, pre.length());
                String fs = file.substring(file.length() - sub.length());
                if(fp.equals(pre) && fs.equals(sub))
                    System.out.println("DA");
                else
                    System.out.println("NE");
            }else{
                System.out.println("NE");
            }
        }

    }
}
