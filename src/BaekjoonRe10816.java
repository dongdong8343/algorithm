import java.io.*;
import java.util.*;
public class BaekjoonRe10816 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> h = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(s1[i]);
            h.put(temp, h.getOrDefault(temp, 0) + 1);
        }

        int m  = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");

        for(int i = 0; i < m; i++){
            int temp = Integer.parseInt(s2[i]);
            Integer ans = h.get(temp);
            if(ans == null){
                bw.write("0 ");
            }else {
                bw.write(ans + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}