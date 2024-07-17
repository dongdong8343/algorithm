import java.util.*;
import java.io.*;
public class Baekjoon28278 {
    static int n;
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                s.push(Integer.parseInt(st.nextToken()));
            }
            else if(a == 2){
                if(s.isEmpty()) bw.write(-1 + "\n");
                else bw.write(s.pop() + "\n");
            }else if(a == 3){
                bw.write(s.size() + "\n");
            }else if(a == 4){
                if(s.isEmpty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            }else if(a == 5){
                if(s.isEmpty()) bw.write(-1 + "\n");
                else bw.write(s.peek() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}