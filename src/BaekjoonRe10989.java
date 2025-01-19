import java.io.*;
import java.util.*;
public class BaekjoonRe10989 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] a = new int[10004];

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            a[temp]++;
        }

        int i = 1;

        while(true){
            if(a[i] != 0) {
                bw.write(i + "\n");
                a[i]--;
            }
            else i++;
            if(i > 10000) break;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}