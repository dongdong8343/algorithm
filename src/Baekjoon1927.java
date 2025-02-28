import java.io.*;
import java.util.*;

public class Baekjoon1927 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(q.isEmpty()) sb.append(0 + "\n");
                else sb.append(q.poll()).append("\n");
            } else q.add(temp);
        }

        System.out.println(sb.toString());


    }

}