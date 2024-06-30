import java.util.*;
import java.io.*;
public class BaekjoonRe5430 {
    static int tc;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> de = new ArrayDeque<>();
        tc = Integer.parseInt(br.readLine());
        for(int s = 0; s < tc; s++){
            String c = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            arr = arr.substring(1, arr.length() - 1);
            String[] arrs = arr.split(",");
            for(int i = 0; i < n; i++)
                de.add(Integer.parseInt(arrs[i]));
            boolean check = false, rev = false;
            for(int i = 0; i < c.length(); i++){
                if(de.isEmpty() && c.charAt(i) == 'D'){
                    check = true;
                    break;
                }
                if(c.charAt(i) == 'R') rev = !rev;
                if(c.charAt(i) == 'D'){
                    if(rev) de.removeLast();
                    else de.removeFirst();
                }
            }
            if(check) System.out.println("error");
            else{
                StringBuilder sb = new StringBuilder("[");
                while(!de.isEmpty()){
                    if(rev) sb.append(de.removeLast());
                    else sb.append(de.removeFirst());
                    if(!de.isEmpty()) sb.append(',');
                }
                sb.append(']');
                System.out.println(sb.toString());
            }
        }
    }
}