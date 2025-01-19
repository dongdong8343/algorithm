import java.util.*;
import java.io.*;
public class BaekjoonRe2751 {
    public static void main(String[] args)throws Exception{
        List<Integer> li = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            li.add(temp);
        }

        Collections.sort(li);

        for(int x : li) bw.write(x + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}